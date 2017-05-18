;; Produced by JasminVisitor (BCEL)
;; http://bcel.sourceforge.net/
;; Sun Dec 11 06:15:44 ICT 2016

.source Input.java
.class  A
.super java/lang/Object

.field static a I
.field  b LA;
.field  c I

.method  <init>()V
.limit stack 1
.limit locals 1
.var 0 is this LA; from Label0 to Label1

Label0:
.line 16
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return

.end method

.method static t(II)I
.limit stack 1
.limit locals 2
.var 0 is arg0 I from Label0 to Label1
.var 1 is arg1 I from Label0 to Label1

Label0:
.line 24
	iconst_0
Label1:
	ireturn

.end method

.method  d(I)V
.limit stack 1
.limit locals 2
.var 0 is this LA; from Label0 to Label1
.var 1 is arg0 I from Label0 to Label1

Label0:
.line 26
	aload_0
	pop
	iconst_5
	putstatic A.a I
Label1:
.line 28
	return

.end method

.method static k(IF)V
.limit stack 0
.limit locals 2
.var 0 is arg0 I from Label0 to Label0
.var 1 is arg1 F from Label0 to Label0

Label0:
.line 29
	return

.end method
