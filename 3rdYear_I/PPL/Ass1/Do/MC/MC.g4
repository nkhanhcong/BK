/**
 * Student name:
 * Student ID:
 */
grammar MC;

@lexer::header{
	package MC.parser;
}

@lexer::members{
@Override
public Token emit() {
    switch (getType()) {
    case UNCLOSE_STRING:       
        Token result = super.emit();
        // you'll need to define this method
        throw new UncloseString(result.getText());
        
    case ILLEGAL_ESCAPE:
    	result = super.emit();
    	throw new IllegalEscape(result.getText());
    case ERROR_CHAR:
    	result = super.emit();
    	throw new ErrorToken(result.getText());	
    default:
        return super.emit();
    }
}
}

@parser::header{
	package MC.parser;
}

options{
	language=Java;
}

program  : 'class' ID LP RP EOF ;         // match keyword hello followed by an identifier
// Character Set
BLANK: (' ');

TAB: ('\t');

FORMFEED: ('\f');

NEWLINE: ('\n');

//Comment
COMMENT: (('/*'[\u0000-\u00FE]*('*/'|EOF))|'%%'(~([\t\r\n])*)) ;


//Keyword
BOOLEAN		: 'bool'	;
BREAK		: 'break'	;
CLASS		: 'class'	;
CONTINUE	: 'continue';
DO			: 'do'		;
ELSE		: 'else'	;
EXTENDS		: 'extends'	;
FLOAT		: 'float'	;
IF 			: 'if'		;
INTEGER		: 'int'	;
NEW 		: 'new'		;
STRING		: 'string'	;
THEN		: 'then'	;
FOR			: 'for'		;
RETURN		: 'return'	;
VOID		: 'void'	;
NIL			: 'nil'		;
THIS		: 'this'	;
FINAL		: 'final'	;
STATIC		: 'static'	;

//operator

PLUS		: '+'		;
MUL			: '*'		;
IN_DIV		: '\\'		;
NOTEQUAL	: '!='		;
LESS		: '<'		;
LESSEQUAL	: '<='		;
OR 			: '||'		;
NOT 		: '!'		;
OBJECTCREAT	: 'new'		;
SUB			:'-'		;
FLOAT_DIV	:'/'		;
MODULUS		:'%'		;
EQUAL		:'=='		;
GREATER		:'>'		;
GREATEREQUAL:'>='		;
CONCA		:'^'		;

//separator

LSB			:'['		;
RSB			:']'		;
LP			:'{'		;
RP			:'}'		;
LB 			:'('		;
RB 			:')'		;
SEMICOLONE	:';'		;
COLON 		:':'		;
DOT			:'.'		;
COMMA		:','		;
ASSIGN		:'='		;

//Literal

INTLIT		:[0-9]+		;

FLOATLIT	:[0-9]+(('.'([0-9]*((('E'|'e')?)|(('E'|'e')('+'|'-')?))))| (('E'|'e')?)) ; 
IDENTIFIER: [a-zA-Z_]+[a-zA-Z_0-9]*;
STRINGLIT	:'"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*'"';
BOOLEANLIT	:('true'|'false');

UNCLOSE_STRING: '"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*;
//ILLEGAL_ESCAPE: .;
//ERROR_CHAR: ;







