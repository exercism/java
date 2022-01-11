declare type Visitor = {
  name: string;
  age: number;
  ticketId: string | null;
};

declare type VisitorWithGtc = Visitor & { gtc?: { version: string } };
