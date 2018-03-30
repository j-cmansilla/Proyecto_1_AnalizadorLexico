/* The following code was generated by JFlex 1.4.3 on 3/30/18 3:27 PM */

package analizador;
import static analizador.Token.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/30/18 3:27 PM from the specification file
 * <tt>C:/Users/Jose Mansilla/Desktop/analizadorLexico-Java/src/analizador/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\45\1\45\2\0\1\45\22\0\1\45\1\36\2\0\1\47"+
    "\1\0\1\37\1\50\2\0\1\35\1\34\1\0\1\34\1\0\1\34"+
    "\12\2\1\0\1\51\1\52\1\46\1\54\1\53\1\0\5\1\1\43"+
    "\2\1\1\42\11\1\1\41\1\44\6\1\4\0\1\32\1\0\1\3"+
    "\1\4\1\10\1\21\1\11\1\22\1\31\1\13\1\17\1\1\1\12"+
    "\1\14\1\23\1\16\1\15\1\24\1\33\1\7\1\5\1\6\1\20"+
    "\1\27\1\26\1\30\1\25\1\1\1\0\1\40\uff83\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\25\1\2\2\1\3\6\1\1\4\2\1\1\0"+
    "\1\5\102\0\1\6\6\0\1\5\10\0\1\6\15\0"+
    "\1\5\34\0\1\5\13\0\1\5\4\0\1\7\20\0"+
    "\1\5\11\0\1\10\11\0\1\11\7\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[223];
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
    "\0\0\0\55\0\132\0\207\0\264\0\341\0\u010e\0\u013b"+
    "\0\u0168\0\u0195\0\u01c2\0\u01ef\0\u021c\0\u0249\0\u0276\0\u02a3"+
    "\0\u02d0\0\u02fd\0\u032a\0\u0357\0\u0384\0\u03b1\0\55\0\u03de"+
    "\0\55\0\u040b\0\u0438\0\u0465\0\u0492\0\u04bf\0\u04ec\0\55"+
    "\0\u0519\0\u0546\0\u0573\0\55\0\u05a0\0\u05cd\0\u05fa\0\u0627"+
    "\0\u0654\0\u0681\0\u06ae\0\u06db\0\u0708\0\u0735\0\u0762\0\u078f"+
    "\0\u07bc\0\u07e9\0\u0816\0\u0843\0\u0870\0\u089d\0\u08ca\0\u08f7"+
    "\0\u0924\0\u0951\0\u097e\0\u09ab\0\u09d8\0\u0a05\0\u0a32\0\u0a5f"+
    "\0\u0a8c\0\u0ab9\0\u0ae6\0\u0b13\0\u0b40\0\u0b6d\0\u01c2\0\u0b9a"+
    "\0\u0bc7\0\u0bf4\0\u0c21\0\u0c4e\0\u0c7b\0\u0ca8\0\u0cd5\0\u0d02"+
    "\0\u0d2f\0\u0d5c\0\u0d89\0\u0db6\0\u0de3\0\u0e10\0\u0e3d\0\u0e6a"+
    "\0\u0e97\0\u0ec4\0\u0ef1\0\u0f1e\0\u0f4b\0\u0f78\0\u0fa5\0\u0fd2"+
    "\0\u0fff\0\u102c\0\u1059\0\u1086\0\u10b3\0\u10e0\0\u110d\0\u113a"+
    "\0\u1167\0\u1194\0\u11c1\0\u11ee\0\u121b\0\u1248\0\u1275\0\u12a2"+
    "\0\u12cf\0\u12fc\0\u1329\0\u1356\0\u1383\0\u13b0\0\55\0\u13dd"+
    "\0\u140a\0\u1437\0\u1464\0\u1491\0\u14be\0\u14eb\0\u1518\0\u1545"+
    "\0\u1572\0\u159f\0\u15cc\0\u15f9\0\u1626\0\u1653\0\u1680\0\u16ad"+
    "\0\u16da\0\u032a\0\u1707\0\u1734\0\u1761\0\u178e\0\u17bb\0\u17e8"+
    "\0\u1815\0\u1842\0\u186f\0\u189c\0\u18c9\0\u18f6\0\u1923\0\u1950"+
    "\0\u197d\0\u19aa\0\u19d7\0\u1a04\0\u1a31\0\u1a5e\0\u1a8b\0\u1ab8"+
    "\0\u1ae5\0\u1b12\0\u1b3f\0\u1b6c\0\u1b99\0\u1bc6\0\u1bf3\0\u1c20"+
    "\0\u1c4d\0\u1c7a\0\u1ca7\0\u1cd4\0\u1d01\0\u1d2e\0\u1d5b\0\u1d88"+
    "\0\u1db5\0\u1de2\0\55\0\u1e0f\0\u1e3c\0\u1e69\0\u1e96\0\u1ec3"+
    "\0\u1b12\0\u1ef0\0\u1f1d\0\u1f4a\0\u1f77\0\u1fa4\0\u1fd1\0\u1ffe"+
    "\0\u202b\0\u2058\0\u2085\0\u20b2\0\u20df\0\u210c\0\u2139\0\u2166"+
    "\0\u2193\0\u21c0\0\u21ed\0\u221a\0\u2247\0\55\0\u2274\0\u22a1"+
    "\0\u22ce\0\u22fb\0\u2328\0\u2355\0\u2382\0\u23af\0\u23dc\0\55"+
    "\0\u2409\0\u2436\0\u2463\0\u2490\0\u24bd\0\u24ea\0\u2517";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[223];
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
    "\3\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\2\2\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\2\1\21\1\22\1\23\1\24\1\25\1\26\2\2"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\2\1\41\2\2\1\42\2\2\61\0"+
    "\1\43\1\44\10\0\1\45\45\0\1\46\53\0\1\47"+
    "\17\0\1\50\35\0\1\51\3\0\1\52\52\0\1\53"+
    "\46\0\1\54\10\0\1\55\1\56\47\0\1\57\3\0"+
    "\1\60\1\0\1\61\4\0\1\62\3\0\1\63\1\64"+
    "\43\0\1\65\44\0\1\31\50\0\1\66\5\0\1\67"+
    "\50\0\1\70\10\0\1\71\3\0\1\44\1\72\36\0"+
    "\1\73\10\0\1\70\47\0\1\74\3\0\1\44\1\0"+
    "\1\73\40\0\1\75\10\0\1\76\1\77\1\0\1\100"+
    "\1\101\43\0\1\102\10\0\1\103\53\0\1\104\50\0"+
    "\1\105\44\0\1\106\66\0\1\107\53\0\1\110\1\111"+
    "\74\0\1\27\56\0\1\31\55\0\1\31\22\0\1\112"+
    "\64\0\1\113\41\0\1\75\10\0\1\76\47\0\1\114"+
    "\46\0\1\115\1\0\31\115\5\0\4\115\63\0\1\116"+
    "\6\0\1\117\70\0\1\31\44\0\1\120\46\0\1\121"+
    "\3\0\1\122\64\0\1\123\40\0\1\124\14\0\1\125"+
    "\4\0\1\44\36\0\1\126\53\0\1\127\24\0\1\130"+
    "\26\0\1\73\1\131\51\0\1\132\11\0\1\133\55\0"+
    "\1\134\51\0\1\135\46\0\1\136\70\0\1\137\57\0"+
    "\1\140\33\0\1\141\57\0\1\142\10\0\1\143\42\0"+
    "\1\143\72\0\1\144\57\0\1\44\33\0\1\145\54\0"+
    "\1\146\1\147\1\0\1\150\70\0\1\151\41\0\1\44"+
    "\53\0\1\152\11\0\1\153\46\0\1\154\55\0\1\155"+
    "\46\0\1\156\63\0\1\157\54\0\1\160\53\0\1\161"+
    "\1\0\1\162\41\0\1\163\61\0\1\164\62\0\1\165"+
    "\44\0\1\44\62\0\1\166\45\0\1\135\55\0\1\122"+
    "\53\0\1\167\66\0\1\125\35\0\33\115\5\0\4\115"+
    "\1\170\1\171\32\0\1\172\36\0\1\173\51\0\1\174"+
    "\57\0\1\175\65\0\1\176\43\0\1\131\65\0\1\143"+
    "\46\0\1\167\60\0\1\67\57\0\1\177\54\0\1\200"+
    "\44\0\1\201\51\0\1\202\65\0\1\73\43\0\1\203"+
    "\1\204\63\0\1\44\50\0\1\205\50\0\1\206\11\0"+
    "\1\207\1\0\1\210\1\211\3\0\1\212\34\0\1\213"+
    "\62\0\1\44\51\0\1\214\51\0\1\44\57\0\1\215"+
    "\54\0\1\143\51\0\1\216\57\0\1\217\57\0\1\220"+
    "\54\0\1\221\54\0\1\222\43\0\1\223\56\0\1\125"+
    "\52\0\1\113\62\0\1\224\46\0\1\225\61\0\1\226"+
    "\52\0\1\227\64\0\1\143\10\0\1\230\41\0\1\175"+
    "\54\0\1\231\54\0\1\73\44\0\1\63\115\0\1\170"+
    "\1\171\10\0\1\232\42\0\1\171\2\0\1\233\17\0"+
    "\1\234\50\0\1\235\57\0\1\44\61\0\1\236\53\0"+
    "\1\237\45\0\1\240\64\0\1\241\50\0\1\44\46\0"+
    "\1\44\55\0\1\242\65\0\1\243\54\0\1\207\63\0"+
    "\1\50\50\0\1\44\43\0\1\244\60\0\1\77\64\0"+
    "\1\44\45\0\1\245\43\0\1\246\52\0\1\247\5\0"+
    "\1\250\52\0\1\251\65\0\1\252\45\0\1\253\46\0"+
    "\1\254\71\0\1\255\37\0\1\131\65\0\1\256\46\0"+
    "\1\257\57\0\1\260\46\0\1\261\72\0\1\44\35\0"+
    "\1\232\42\0\1\262\3\0\1\263\4\0\1\264\1\0"+
    "\31\264\5\0\4\264\1\233\33\0\1\265\33\0\1\266"+
    "\61\0\1\44\75\0\1\167\41\0\1\44\45\0\1\267"+
    "\46\0\1\270\1\0\31\270\5\0\4\270\1\271\25\0"+
    "\1\272\46\0\1\152\65\0\1\202\57\0\1\273\46\0"+
    "\1\274\41\0\1\275\73\0\1\273\53\0\1\267\56\0"+
    "\1\276\40\0\1\73\61\0\1\143\54\0\1\213\57\0"+
    "\1\277\45\0\1\300\52\0\1\73\113\0\1\262\3\0"+
    "\1\263\4\0\1\264\1\0\31\264\5\0\5\264\2\0"+
    "\1\262\14\0\1\301\34\0\1\265\1\0\1\302\3\0"+
    "\1\303\11\0\1\143\55\0\1\304\44\0\33\270\5\0"+
    "\4\270\1\305\1\306\26\0\1\73\37\0\1\307\61\0"+
    "\1\310\65\0\1\311\44\0\1\312\60\0\1\240\45\0"+
    "\1\313\63\0\1\314\40\0\1\315\1\0\31\315\5\0"+
    "\4\315\64\0\1\316\32\0\1\317\67\0\1\305\1\306"+
    "\10\0\1\320\42\0\1\306\2\0\1\321\14\0\1\73"+
    "\55\0\1\311\60\0\1\207\55\0\1\322\47\0\1\231"+
    "\61\0\1\323\37\0\33\315\5\0\4\315\1\324\1\325"+
    "\23\0\1\326\41\0\1\320\42\0\1\327\3\0\1\330"+
    "\4\0\1\331\1\0\31\331\5\0\4\331\1\321\15\0"+
    "\1\202\53\0\1\332\114\0\1\324\1\325\10\0\1\333"+
    "\42\0\1\325\2\0\1\334\22\0\1\307\103\0\1\327"+
    "\3\0\1\330\4\0\1\331\1\0\31\331\5\0\5\331"+
    "\2\0\1\327\12\0\1\335\50\0\1\333\42\0\1\336"+
    "\3\0\1\265\4\0\1\337\1\0\31\337\5\0\4\337"+
    "\1\334\10\0\1\315\1\0\31\315\5\0\4\315\1\335"+
    "\54\0\1\336\3\0\1\265\4\0\1\337\1\0\31\337"+
    "\5\0\5\337\2\0\1\336\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9540];
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
    "\1\0\1\11\24\1\1\11\1\1\1\11\6\1\1\11"+
    "\2\1\1\0\1\11\102\0\1\1\6\0\1\1\10\0"+
    "\1\11\15\0\1\1\34\0\1\1\13\0\1\1\4\0"+
    "\1\11\20\0\1\1\11\0\1\11\11\0\1\11\7\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[223];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  public int yyline;

  /** the number of characters up to the start of the matched text */
  public int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
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
    while (i < 136) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
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
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
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
    return zzBuffer[zzStartRead+pos];
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
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
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
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
        case 4: 
          { /*ignore*/
          }
        case 10: break;
        case 9: 
          { return CONSTANTE;
          }
        case 11: break;
        case 1: 
          { return ERROR;
          }
        case 12: break;
        case 5: 
          { return PALABRARESERVADA;
          }
        case 13: break;
        case 3: 
          { return OPERADORLOGICO;
          }
        case 14: break;
        case 6: 
          { return TIPODEDATO;
          }
        case 15: break;
        case 2: 
          { return OPERADORARITMETICO;
          }
        case 16: break;
        case 8: 
          { return CORRECTO;
          }
        case 17: break;
        case 7: 
          { return VARIABLE;
          }
        case 18: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
