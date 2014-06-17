/* The following code was generated by JFlex 1.4.3 on 17/06/14 13:19 */

package com.technophobia.substeps.lexer.feature;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.technophobia.substeps.psi.feature.FeatureTypes;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 17/06/14 13:19 from the specification file
 * <tt>/home/sforbes/checkouts/personal/substeps/idea/substeps-idea/src/com/technophobia/substeps/lexer/feature/Feature.flex</tt>
 */
public class FeatureLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int CREATING_FEATURE_TEXT = 2;
  public static final int CREATING_TAGS_TEXT = 4;
  public static final int YYINITIAL = 0;
  public static final int CREATING_SCENARIO_TEXT = 6;
  public static final int CREATING_SCENARIO_OUTLINE_TEXT = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\6\1\2\1\0\1\5\1\1\22\0\1\3\1\30\1\0"+
    "\1\30\26\0\1\15\13\0\1\7\10\0\1\26\3\0\1\21\1\16"+
    "\7\0\1\4\4\0\1\11\1\0\1\22\1\0\1\10\1\0\1\17"+
    "\1\0\1\24\2\0\1\27\1\0\1\23\1\25\2\0\1\14\1\20"+
    "\1\12\1\13\uff8a\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\2\2\1\3\3\1\1\4\1\5\1\6"+
    "\1\1\1\6\1\7\1\10\1\1\1\10\1\11\1\12"+
    "\1\1\1\12\1\13\1\14\1\1\1\14\1\15\1\0"+
    "\1\15\4\0\1\5\1\0\1\7\1\0\1\11\1\0"+
    "\1\13\1\15\7\0\1\16\5\0\1\17\2\0\1\20"+
    "\7\0\1\21";

  private static int [] zzUnpackAction() {
    int [] result = new int[69];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\31\0\62\0\113\0\144\0\175\0\226\0\175"+
    "\0\257\0\310\0\341\0\372\0\u0113\0\u012c\0\u0145\0\u015e"+
    "\0\u0177\0\u0190\0\u01a9\0\u01c2\0\u01db\0\u01f4\0\u020d\0\u0226"+
    "\0\u023f\0\u0258\0\u0271\0\u028a\0\u02a3\0\u02bc\0\u02d5\0\u02ee"+
    "\0\u0307\0\u0320\0\u0339\0\u015e\0\u0352\0\u01c2\0\u036b\0\u0226"+
    "\0\u0384\0\u028a\0\u039d\0\u03b6\0\u03cf\0\u03e8\0\u0401\0\u041a"+
    "\0\u0433\0\u044c\0\u0465\0\175\0\u047e\0\u0497\0\u04b0\0\u04c9"+
    "\0\u04e2\0\175\0\u04fb\0\u0514\0\175\0\u052d\0\u0546\0\u055f"+
    "\0\u0578\0\u0591\0\u05aa\0\u05c3\0\175";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[69];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\6\1\7\1\10\1\11\1\6\2\11\1\12\6\6"+
    "\1\13\2\6\1\14\6\6\1\15\1\16\1\7\1\10"+
    "\1\17\1\20\1\17\1\21\22\16\1\22\1\7\1\10"+
    "\1\23\1\24\1\23\1\25\22\22\1\26\1\7\1\10"+
    "\1\27\1\30\1\27\1\31\22\26\1\32\1\7\1\10"+
    "\1\33\1\34\1\33\1\35\22\32\33\0\1\10\26\0"+
    "\1\36\2\0\1\11\1\37\1\11\1\40\22\36\10\0"+
    "\1\41\31\0\1\42\41\0\1\43\6\0\1\15\2\0"+
    "\26\15\1\16\2\0\1\16\1\44\1\0\23\16\3\0"+
    "\1\17\1\0\2\17\22\0\1\16\1\45\30\16\2\0"+
    "\1\21\1\44\1\17\1\21\22\16\1\22\2\0\1\22"+
    "\1\46\1\0\23\22\3\0\1\23\1\0\2\23\22\0"+
    "\1\22\1\47\30\22\2\0\1\25\1\46\1\23\1\25"+
    "\22\22\1\26\2\0\1\26\1\50\1\0\23\26\3\0"+
    "\1\27\1\0\2\27\22\0\1\26\1\51\30\26\2\0"+
    "\1\31\1\50\1\27\1\31\22\26\1\32\2\0\1\32"+
    "\1\52\1\0\23\32\3\0\1\33\1\0\2\33\22\0"+
    "\1\32\1\53\30\32\2\0\1\35\1\52\1\33\1\35"+
    "\22\32\1\36\2\0\1\36\1\37\1\0\24\36\1\54"+
    "\30\36\2\0\1\40\1\37\1\11\1\40\22\36\11\0"+
    "\1\55\36\0\1\56\21\0\1\57\20\0\1\16\1\0"+
    "\2\16\1\44\1\0\23\16\1\22\1\0\2\22\1\46"+
    "\1\0\23\22\1\26\1\0\2\26\1\50\1\0\23\26"+
    "\1\32\1\0\2\32\1\52\1\0\23\32\1\36\1\0"+
    "\2\36\1\37\1\0\23\36\12\0\1\60\36\0\1\61"+
    "\33\0\1\62\20\0\1\63\32\0\1\64\24\0\1\65"+
    "\33\0\1\66\30\0\1\67\24\0\1\70\44\0\1\71"+
    "\21\0\1\72\40\0\1\73\6\0\1\74\1\0\2\74"+
    "\6\0\1\75\41\0\1\76\15\0\1\77\27\0\1\100"+
    "\45\0\1\101\25\0\1\102\27\0\1\103\15\0\1\104"+
    "\35\0\1\105\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1500];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\1\11\1\1\1\11\26\1\1\0\1\1\4\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\2\1\7\0"+
    "\1\11\5\0\1\11\2\0\1\11\7\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[69];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  public FeatureLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public FeatureLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 86) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
        return;

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 12: 
          { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return TokenType.WHITE_SPACE;
          }
        case 18: break;
        case 4: 
          { yybegin(YYINITIAL); return FeatureTypes.COMMENT;
          }
        case 19: break;
        case 3: 
          { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;
          }
        case 20: break;
        case 14: 
          { yybegin(CREATING_TAGS_TEXT); return FeatureTypes.TAGS_LABEL;
          }
        case 21: break;
        case 8: 
          { yybegin(CREATING_TAGS_TEXT); return TokenType.WHITE_SPACE;
          }
        case 22: break;
        case 11: 
          { yybegin(YYINITIAL); return FeatureTypes.SCENARIO_OUTLINE_TEXT;
          }
        case 23: break;
        case 16: 
          { yybegin(CREATING_SCENARIO_TEXT); return FeatureTypes.SCENARIO_LABEL;
          }
        case 24: break;
        case 10: 
          { yybegin(CREATING_SCENARIO_TEXT); return TokenType.WHITE_SPACE;
          }
        case 25: break;
        case 15: 
          { yybegin(CREATING_FEATURE_TEXT); return FeatureTypes.FEATURE_LABEL;
          }
        case 26: break;
        case 7: 
          { yybegin(YYINITIAL); return FeatureTypes.TAGS_TEXT;
          }
        case 27: break;
        case 1: 
          { return TokenType.BAD_CHARACTER;
          }
        case 28: break;
        case 2: 
          { yybegin(YYINITIAL); return FeatureTypes.CRLF;
          }
        case 29: break;
        case 13: 
          { yybegin(YYINITIAL); return FeatureTypes.STEP;
          }
        case 30: break;
        case 9: 
          { yybegin(YYINITIAL); return FeatureTypes.SCENARIO_TEXT;
          }
        case 31: break;
        case 5: 
          { yybegin(YYINITIAL); return FeatureTypes.FEATURE_TEXT;
          }
        case 32: break;
        case 6: 
          { yybegin(CREATING_FEATURE_TEXT); return TokenType.WHITE_SPACE;
          }
        case 33: break;
        case 17: 
          { yybegin(CREATING_SCENARIO_OUTLINE_TEXT); return FeatureTypes.SCENARIO_OUTLINE_LABEL;
          }
        case 34: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}