.source TAPPLClass.java
.class public TAPPLClass
.super ABC
.field b Ljava/lang/String;

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is b I from Label0 to Label1
.var 2 is x LTAPPLClass; from Label0 to Label1
Label0:
	new TAPPLClass
	dup
	invokespecial TAPPLClass/<init>()V
	astore_2
	invokestatic TAPPLClass/func()I
	istore_1
	getstatic TAPPLClass.one I
	invokestatic io/writeIntLn(I)V
	iload_1
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 3
.limit locals 3
.end method

.method public <init>()V
.var 0 is this LTAPPLClass; from Label0 to Label1
Label0:
	aload_0
	invokespecial ABC/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
