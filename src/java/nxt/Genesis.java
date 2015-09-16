/******************************************************************************
 * Copyright © 2013-2015 The Nxt Core Developers.                             *
 *                                                                            *
 * See the AUTHORS.txt, DEVELOPER-AGREEMENT.txt and LICENSE.txt files at      *
 * the top-level directory of this distribution for the individual copyright  *
 * holder information and the developer policies on copyright and licensing.  *
 *                                                                            *
 * Unless otherwise agreed in a custom licensing agreement, no part of the    *
 * Nxt software, including this file, may be copied, modified, propagated,    *
 * or distributed except according to the terms contained in the LICENSE.txt  *
 * file.                                                                      *
 *                                                                            *
 * Removal or modification of this copyright notice is prohibited.            *
 *                                                                            *
 ******************************************************************************/

package nxt;

import java.math.BigInteger;

public final class Genesis {
    /*
CREATOR_ID -    	{-87,-76,77,-60,41,16,-60,-98,-92,-115,62,-95,88,-34,-23,-86,115,46,32,62,-50,-102,67,-64,115,122,82,51,27,-113,-56,12},	18,	206601722580326317,	r%&JuI9@gN*w0$FWFp046eb*N28I&2mu^Bb,	NXT-6PXF-7J88-4RDF-2ZHR7
GENESIS_RECIPIENTS[0]	{76,-77,-30,3,-2,50,12,54,-11,-123,52,-28,-91,-44,-25,98,114,47,15,55,48,48,-95,82,-18,-107,-107,-70,127,41,-1,5},	17,	88694087919409907,	S4Fum4Z*@AsH6sohrn#1!e^I6K5j1hs8mQq,	NXT-U8RM-TQC3-NB6D-2USG4
GENESIS_RECIPIENTS[1]	{-2,-61,30,118,46,17,-48,80,-78,30,-14,0,-89,-1,124,24,127,-47,49,-55,-64,-112,28,116,-83,73,8,-83,104,35,99,29},	15,	421287889494673,	H8$2S^Hr6J$kSGADqpbB#3XhPV56!YIS1WW,	NXT-2SNK-74XJ-EULY-2ZD22
GENESIS_RECIPIENTS[2]	{-25,-28,-100,-36,17,-49,26,120,40,-33,20,-92,47,51,-113,-72,117,-123,86,115,1,16,-37,28,-63,-67,15,-50,-68,91,-123,64},	13,	3628561553453,	0XUFe0ccDbQEQV$ukpKxu$s1N&wjrTKOCJ@,	NXT-YQ3F-BMDK-H79S-25222
GENESIS_RECIPIENTS[3]	{75,31,76,109,30,-22,-10,-24,-84,26,65,24,-113,76,-5,30,-51,-62,-1,-47,16,-36,118,-94,46,-104,108,47,42,79,54,47},	18,	612636505794420806,	Hwxc2komnNb2c#!$Fj0bZ7MV9X39&FRd*Oi,	NXT-2A48-NZW7-NRUQ-2762K
GENESIS_RECIPIENTS[4]	{-17,-128,-126,80,107,121,-83,101,-80,-57,-90,-47,114,-77,122,-40,27,100,-128,-86,19,-88,5,25,114,-70,30,57,103,81,110,37},	17,	44042107643624849,	kX0jb7fR!WVTEof&Un2mHO^3X7aGER&56vY,	NXT-5ZEK-434N-E88E-2S593
GENESIS_RECIPIENTS[5]	{123,-121,-113,-94,123,-125,-10,45,113,-21,-110,35,-6,-75,-50,126,-103,30,-62,10,125,-105,-86,-83,112,-69,98,-19,7,-90,-38,64},	16,	5237983554060355,	*a!yiapZCD$nTpB#d*8$DTKX7r3h8hUPvd6,	NXT-AJ45-XECK-L548-2VN62
     */

    public static final long GENESIS_BLOCK_ID = 777777777777777L;
    public static final long CREATOR_ID = 206601722580326317L;
    public static final byte[] CREATOR_PUBLIC_KEY = {
            -87,-76,77,-60,41,16,-60,-98,-92,-115,62,-95,88,-34,-23,-86,115,46,32,62,-50,-102,67,-64,115,122,82,51,27,-113,-56,12
    };

    public static final long[] GENESIS_RECIPIENTS = {
            (new BigInteger("88694087919409907")).longValue()
//            (new BigInteger("421287889494673")).longValue(),
//            (new BigInteger("3628561553453")).longValue(),
//            (new BigInteger("612636505794420806")).longValue(),
//            (new BigInteger("44042107643624849")).longValue(),
//            (new BigInteger("5237983554060355")).longValue(),
   };

    public static final int[] GENESIS_AMOUNTS = {
            10000
//            20000,
//            30000,
//            40000,
//            50000,
//            60000
    };

    public static final byte[][] GENESIS_SIGNATURES = { //Tx signatures
            {1,1,1,2,3,1}
     };

    public static final byte[] GENESIS_BLOCK_SIGNATURE = new byte[]{
//            105, -44, 38, -60, -104, -73, 10, -58, -47, 103, -127, -128, 53, 101, 39, -63, -2, -32, 48, -83, 115, 47, -65, 118, 114, -62, 38, 109, 22, 106, 76, 8, -49, -113, -34, -76, 82, 79, -47, -76, -106, -69, -54, -85, 3, -6, 110, 103, 118, 15, 109, -92, 82, 37, 20, 2, 36, -112, 21, 72, 108, 72, 114, 17
    };

    private Genesis() {} // never

}

//public final class Genesis {
//
//    public static final Long GENESIS_BLOCK_ID = -5984289973625010005L;
//    public static final Long CREATOR_ID = 1763558929574856152L ;
//    public static final byte[] CREATOR_PUBLIC_KEY = {93, -35, 98, 93, -99, -74, 24, -91, -6, -18, 14, 38, -36, 67, -90, -47, 32, 8, 99, -6, -128, -106, -40, 61, 11, -110, 64, 1, 96, -98, 89, 42
//    };
//
//    public static final Long[] GENESIS_RECIPIENTS = {
//            (new BigInteger("96881528246")).longValue(),
//            (new BigInteger("90946780850")).longValue(),
//            (new BigInteger("83240577465")).longValue(),
//            (new BigInteger("42584218847")).longValue(),
//            (new BigInteger("35225813665")).longValue()
//    };
//
//
//    public static final int[] GENESIS_AMOUNTS = {
//            1900000000,
//            1425000000,
//            950000000,
//            475000000,
//            250000000
//    };
//
//    public static final byte[][] GENESIS_SIGNATURES = {
//            {5, -99, -78, -110, -115, -97, 105, -114, -101, -21, 91, -96, 7, 119, -15, -70, -128, -93, -55, -84, 83, -20, 0, 13, -87, 64, -35, 63, 80, -84, 87, 10, -75, -55, 52, 30, 14, -107, 83, 85, -121, -66, 92, -99, -48, -61, -66, -62, 66, 60, -59, 21, -61, 1, -49, -22, -83, 99, -64, -101, 8, -5, 17, 13},
//            {-98, 52, 35, 4, -106, -60, 38, 52, 102, 38, 110, 49, -73, -29, -12, 100, 66, 122, -90, 5, -122, -32, 47, -72, -95, -78, 9, 31, -82, -2, 89, 10, 19, 54, -124, 62, 76, 35, 65, -33, 65, -9, -121, -95, 11, -92, -16, 32, 47, 34, 65, -10, -63, 99, 8, 53, 66, -82, -117, 66, 127, 50, 31, -16},
//            {-101, 19, -109, 80, -47, -82, -27, 73, 81, 59, 17, -26, -115, -125, -14, 48, 83, -102, -51, 127, 36, 36, 1, -31, -96, 118, 115, -93, 119, 119, -79, 3, 102, -125, -68, 36, -36, 95, 81, 106, -100, 35, 100, -100, 33, -22, 25, -58, -124, 104, -32, -90, 79, 116, -61, -112, 123, -78, -43, 41, -112, 85, -99, 59},
//            {-121, -73, -53, -33, -35, 105, 107, 73, -64, 67, -38, 42, -52, 81, 105, 120, 44, 69, -67, -106, 90, 97, -91, 70, 29, 33, -20, 50, -43, 100, 39, 12, 99, 75, 94, 70, -99, 74, -53, 39, 82, -16, -12, 104, 64, -69, -27, -13, 41, 127, 69, 55, 59, -43, 41, 26, -111, 64, -91, -101, -94, 8, -110, 83},
//            { -16, 116, 87, 126, -48, 66, 57, 127, -99, 82, 61, -39, -60, 125, -89, -59, 57, 18, 17, 109, -69, 99, -73, 68, 78, -68, -38, 19, 116, 125, 35, 15, -107, 39, 12, -52, 58, 35, 121, 32, 18, 32, -7, 103, -67, 115, -102, 124, -45, -55, 29, -105, 73, -67, -123, 29, 88, 77, 28, 65, -34, -121, -50, 6}
//    };
//
//    public static final byte[] GENESIS_BLOCK_SIGNATURE = new byte[]{
//            -51, 122, 40, -113, -90, 63, -63, -22, -96, -104, 22, 40, -37, -72, 6, 39, 3, -88, 52, 49, -83, 59, -79, 118, 113, 54, 123, -18, -24, -47, -13, 3, 29, -67, 1, -17, -54, 11, -74, -85, 28, -112, -53, -64, 31, 75, 14, 113, 32, 112, -113, 2, 48, 43, -4, 58, -126, 78, -23, -106, 98, -106, 110, 22
//    };
//
//    private Genesis() {} // never
//
//}