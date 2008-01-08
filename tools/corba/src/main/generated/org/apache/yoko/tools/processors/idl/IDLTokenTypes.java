// $ANTLR 2.7.4: "idl.g" -> "IDLParser.java"$

  package org.apache.yoko.tools.processors.idl;

  import java.io.*;
  import java.util.Vector;
  import java.util.Hashtable;
 
public interface IDLTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int SEMI = 4;
	int LITERAL_abstract = 5;
	int LITERAL_local = 6;
	int LITERAL_interface = 7;
	int LITERAL_custom = 8;
	int LITERAL_valuetype = 9;
	int LITERAL_eventtype = 10;
	int LITERAL_module = 11;
	int LCURLY = 12;
	int RCURLY = 13;
	int COLON = 14;
	int COMMA = 15;
	int SCOPEOP = 16;
	int IDENT = 17;
	int LITERAL_truncatable = 18;
	int LITERAL_supports = 19;
	int LITERAL_public = 20;
	int LITERAL_private = 21;
	int LITERAL_factory = 22;
	int LPAREN = 23;
	int RPAREN = 24;
	int LITERAL_in = 25;
	int LITERAL_const = 26;
	int ASSIGN = 27;
	int OR = 28;
	int XOR = 29;
	int AND = 30;
	int LSHIFT = 31;
	int RSHIFT = 32;
	int PLUS = 33;
	int MINUS = 34;
	int STAR = 35;
	int DIV = 36;
	int MOD = 37;
	int TILDE = 38;
	int LITERAL_TRUE = 39;
	int LITERAL_FALSE = 40;
	int LITERAL_typedef = 41;
	int LITERAL_native = 42;
	int LITERAL_float = 43;
	int LITERAL_double = 44;
	int LITERAL_long = 45;
	int LITERAL_short = 46;
	int LITERAL_unsigned = 47;
	int LITERAL_char = 48;
	int LITERAL_wchar = 49;
	int LITERAL_boolean = 50;
	int LITERAL_octet = 51;
	int LITERAL_any = 52;
	int LITERAL_Object = 53;
	int LITERAL_struct = 54;
	int LITERAL_union = 55;
	int LITERAL_switch = 56;
	int LITERAL_case = 57;
	int LITERAL_default = 58;
	int LITERAL_enum = 59;
	int LITERAL_sequence = 60;
	int LT = 61;
	int GT = 62;
	int LITERAL_string = 63;
	int LITERAL_wstring = 64;
	int LBRACK = 65;
	int RBRACK = 66;
	int LITERAL_exception = 67;
	int LITERAL_oneway = 68;
	int LITERAL_void = 69;
	int LITERAL_out = 70;
	int LITERAL_inout = 71;
	int LITERAL_raises = 72;
	int LITERAL_context = 73;
	int LITERAL_fixed = 74;
	int LITERAL_ValueBase = 75;
	int LITERAL_import = 76;
	int LITERAL_typeid = 77;
	int LITERAL_typeprefix = 78;
	int LITERAL_readonly = 79;
	int LITERAL_attribute = 80;
	int LITERAL_getraises = 81;
	int LITERAL_setraises = 82;
	int LITERAL_component = 83;
	int LITERAL_provides = 84;
	int LITERAL_uses = 85;
	int LITERAL_multiple = 86;
	int LITERAL_emits = 87;
	int LITERAL_publishes = 88;
	int LITERAL_consumes = 89;
	int LITERAL_home = 90;
	int LITERAL_manages = 91;
	int LITERAL_primarykey = 92;
	int LITERAL_finder = 93;
	int INT = 94;
	int OCTAL = 95;
	int HEX = 96;
	int STRING_LITERAL = 97;
	int WIDE_STRING_LITERAL = 98;
	int CHAR_LITERAL = 99;
	int WIDE_CHAR_LITERAL = 100;
	int FIXED = 101;
	int FLOAT = 102;
	int QUESTION = 103;
	int DOT = 104;
	int NOT = 105;
	int WS = 106;
	int PREPROC_DIRECTIVE = 107;
	int SL_COMMENT = 108;
	int ML_COMMENT = 109;
	int ESC = 110;
	int VOCAB = 111;
	int DIGIT = 112;
	int NONZERODIGIT = 113;
	int OCTDIGIT = 114;
	int HEXDIGIT = 115;
	int ESCAPED_IDENT = 116;
}
