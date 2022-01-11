import {
  createVisitor,
  revokeTicket,
  ticketStatus,
  simpleTicketStatus,
  gtcVersion,
} from './amusement-park';

describe('createVisitor', () => {
  test('correctly assembles the visitor object', () => {
    const expected1 = { name: 'Imran Kudrna', age: 21, ticketId: 'ECMZR67C' };
    const expected2 = { name: 'Nālani Sansone', age: 76, ticketId: 'YX52GB06' };
    const expected3 = { name: 'Bogiła Kalš', age: 55, ticketId: '30Z2OKJP' };

    expect(createVisitor('Imran Kudrna', 21, 'ECMZR67C')).toEqual(expected1);
    expect(createVisitor('Nālani Sansone', 76, 'YX52GB06')).toEqual(expected2);
    expect(createVisitor('Bogiła Kalš', 55, '30Z2OKJP')).toEqual(expected3);
  });
});

describe('revokeTicket', () => {
  test('sets the ticketId to null', () => {
    const visitor = { name: 'María Pilar Neri', age: 16, ticketId: 'MFBSF3S2' };

    const expected = { name: 'María Pilar Neri', age: 16, ticketId: null };
    expect(revokeTicket(visitor)).toEqual(expected);
  });

  test('returns the same object that was passed in', () => {
    const visitor = { name: 'Anatoli Traverse', age: 34, ticketId: 'AA5AA01D' };

    // This checks that the same object that was passed in is returned.
    // https://jestjs.io/docs/expect#tobevalue
    expect(Object.is(revokeTicket(visitor), visitor)).toBe(true);
  });

  test('does nothing if the ticket was already revoked', () => {
    const visitor = { name: 'Min-Ji Chu', age: 51, ticketId: null };
    const actual = revokeTicket(visitor);

    expect(actual).toEqual(visitor);
    // This checks that the same object that was passed in is returned.
    expect(Object.is(actual, visitor)).toBe(true);
  });
});

describe('ticketStatus', () => {
  test('correctly identifies that a ticket is not in the tracking object', () => {
    expect(ticketStatus(testTickets(), 'Y4KXZOYM')).toBe('unknown ticket id');
    expect(ticketStatus(testTickets(), '8ATQC1ZJ')).toBe('unknown ticket id');
    expect(ticketStatus(testTickets(), 'G833HR8A')).toBe('unknown ticket id');
  });

  test('correctly identifies that a ticket is not sold', () => {
    expect(ticketStatus(testTickets(), 'V42NWRMQ')).toBe('not sold');
    expect(ticketStatus(testTickets(), 'A56MTX8E')).toBe('not sold');
    expect(ticketStatus(testTickets(), 'YEVHK4MC')).toBe('not sold');
  });

  test('returns the correct string for a ticket that was sold', () => {
    const actual1 = ticketStatus(testTickets(), 'QINS6S94');
    expect(actual1).toBe('sold to Hong Hsu');

    const actual2 = ticketStatus(testTickets(), 'H31SAW5Q');
    expect(actual2).toBe('sold to Lior MacNeil');

    const actual3 = ticketStatus(testTickets(), 'M9ZTXP89');
    expect(actual3).toBe('sold to Kamani Ybarra');
  });
});

describe('simpleTicketStatus', () => {
  test('identifies ticket that are not in the tracking object as invalid', () => {
    const expected = 'invalid ticket !!!';
    expect(simpleTicketStatus(testTickets(), 'Y4KXZOYM')).toBe(expected);
    expect(simpleTicketStatus(testTickets(), '8ATQC1ZJ')).toBe(expected);
    expect(simpleTicketStatus(testTickets(), 'G833HR8A')).toBe(expected);
  });

  test('identifies tickets that are not sold as invalid', () => {
    const expected = 'invalid ticket !!!';
    expect(simpleTicketStatus(testTickets(), 'V42NWRMQ')).toBe(expected);
    expect(simpleTicketStatus(testTickets(), 'A56MTX8E')).toBe(expected);
    expect(simpleTicketStatus(testTickets(), 'YEVHK4MC')).toBe(expected);
  });

  test('returns the visitor name for tickets that were sold', () => {
    expect(simpleTicketStatus(testTickets(), 'QINS6S94')).toBe('Hong Hsu');
    expect(simpleTicketStatus(testTickets(), 'H31SAW5Q')).toBe('Lior MacNeil');
    expect(simpleTicketStatus(testTickets(), 'M9ZTXP89')).toBe('Kamani Ybarra');
  });

  test('tickets with "strange" name values are valid nevertheless', () => {
    const tickets = {
      B7627X32: '',
      XF1X6S2W: 0,
      KJJIFFO0: false,
    };

    const unexpected = 'invalid ticket !!!';
    expect(simpleTicketStatus(tickets, 'B7627X32')).not.toEqual(unexpected);
    expect(simpleTicketStatus(tickets, 'XF1X6S2W')).not.toEqual(unexpected);
    expect(simpleTicketStatus(tickets, 'KJJIFFO0')).not.toEqual(unexpected);
  });
});

describe('gtcVersion', () => {
  test('determines the GTC version if it is present', () => {
    const visitor1 = {
      name: 'Zohar Pekkanen',
      age: 28,
      ticketId: '8DGM3163',
      gtc: {
        signed: true,
        version: '4.2',
      },
    };

    const visitor2 = {
      name: 'Fen Van der Hout',
      age: 70,
      ticketId: 'BMYPNZGT',
      gtc: {
        signed: true,
        version: '1.6',
      },
    };

    expect(gtcVersion(visitor1)).toBe('4.2');
    expect(gtcVersion(visitor2)).toBe('1.6');
  });

  test('returns nothing if there is no gtc object', () => {
    const visitor1 = {
      name: 'Xuân Jahoda',
      age: 15,
      ticketId: 'NZGKELXC',
    };

    const visitor2 = {
      name: 'Micha Tót',
      age: 49,
      ticketId: '3BGCW1G9',
    };

    expect(gtcVersion(visitor1)).toBeUndefined();
    expect(gtcVersion(visitor2)).toBeUndefined();
  });

  test('returns nothing if there is a gtc object but no gtc version', () => {
    const visitor1 = {
      name: 'Xuân Jahoda',
      age: 15,
      ticketId: 'NZGKELXC',
      gtc: {},
    };

    const visitor2 = {
      name: 'Micha Tót',
      age: 49,
      ticketId: '3BGCW1G9',
      gtc: {
        signed: false,
      },
    };

    expect(gtcVersion(visitor1)).toBeUndefined();
    expect(gtcVersion(visitor2)).toBeUndefined();
  });

  test('does not modify the visitor object', () => {
    const visitor = {
      name: 'Zohar Pekkanen',
      age: 28,
      ticketId: '8DGM3163',
    };

    const expected = {
      name: 'Zohar Pekkanen',
      age: 28,
      ticketId: '8DGM3163',
    };

    gtcVersion(visitor);
    expect(visitor).toEqual(expected);
  });
});

const testTickets = () => {
  return {
    QINS6S94: 'Hong Hsu',
    V42NWRMQ: null,
    A56MTX8E: null,
    H31SAW5Q: 'Lior MacNeil',
    M9ZTXP89: 'Kamani Ybarra',
    YEVHK4MC: null,
  };
};
