import java.util.ArrayList;
import java.util.List;

public class IntergalacticTransmission {

    private static final byte INIT_UPPER_MASK = (byte) 0xFE;

    public static List<Integer> getTransmitSequence(List<Integer> message) {
        List<Integer> transmitSeq = new ArrayList<>();
        byte carry = 0;
        byte upperMask = INIT_UPPER_MASK;

        for (int i = 0; i < message.size(); i++) {
            byte currentByte = message.get(i).byteValue();

            if (upperMask == 0) {
                transmitSeq.add((int) addParity(carry) & 0xFF);
                carry = 0;
                upperMask = (byte) 0xFE;
            }

            int shiftPlaces = Integer.numberOfTrailingZeros(upperMask & 0xFF);
            int current = ((carry & 0xFF) << (8 - shiftPlaces)) | ((currentByte & 0xFF) >>> shiftPlaces);
            transmitSeq.add((int) addParity((byte) current) & 0xFF);

            carry = (byte) (currentByte & ~upperMask);
            upperMask = (byte) (upperMask << 1);
        }

        if (upperMask != INIT_UPPER_MASK) {
            byte lastGroup = (byte) ((carry & 0xFF) << Integer.bitCount(upperMask & 0xFF));
            transmitSeq.add((int) addParity(lastGroup) & 0xFF);
        }

        return transmitSeq;
    }

    private static byte addParity(byte source) {
        if (Integer.bitCount(source & 0x7F) % 2 == 0) {
            return (byte) (source << 1);
        } else {
            return (byte) ((source << 1) | 1);
        }
    }

    public static List<Integer> decodeSequence(List<Integer> receivedSeq) {
        if (receivedSeq.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> decodedMessage = new ArrayList<>();
        byte byteToAdd = 0x00;
        byte upperMask = (byte) 0xFF;

        for (int i = 0; i < receivedSeq.size(); i++) {
            byte currentByte = receivedSeq.get(i).byteValue();

            if (upperMask == (byte) 0xFF) {
                byteToAdd = getByteData(currentByte);
                upperMask = (byte) 0x80;
                continue;
            }

            byte currentByteData = getByteData(currentByte);
            int shiftPlaces = Integer.numberOfTrailingZeros(upperMask & 0xFF);
            byte contribution = (byte) ((currentByteData & 0xFF) >>> shiftPlaces);
            decodedMessage.add((byteToAdd | contribution) & 0xFF);

            byteToAdd = (byte) (((currentByteData & ~(upperMask | 0x01)) & 0xFF) << Integer.bitCount(upperMask & 0xFF));
            upperMask = (byte) (((upperMask & 0xFF) >>> 1) | 0x80);
        }

        return decodedMessage;
    }

    private static byte getByteData(byte data) {
        if (Integer.bitCount(data & 0xFF) % 2 != 0) {
            throw new IllegalArgumentException("Byte has incorrect parity");
        }
        return (byte) (data & 0xFE);
    }
}
