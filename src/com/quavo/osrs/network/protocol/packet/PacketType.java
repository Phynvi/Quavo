package com.quavo.osrs.network.protocol.packet;

/**
 * An enumeration which contains the different types of packets.
 *
 * @author Graham
 */
public enum PacketType {

    /**
     * A packet where the length is known by both the client and server already.
     */
    FIXED,

    /**
     * A packet where the length is sent to its destination with it as a byte.
     */
    VARIABLE_BYTE,

    /**
     * A packet where the length is sent to its destination with it as a short.
     */
    VARIABLE_SHORT;

}
