.source TAPPLClass.java
.class public TAPPLClass
.super A1

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x LTAPPLClass; from Label0 to Label1
.var 2 is a I from Label0 to Label1
Label0:
	new TAPPLClass
	dup
	invokespecial TAPPLClass/<init>()V
	astore_1
	aload_1
	getfield TAPPLClass.b I
	istore_2
	iload_2
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 2
.limit locals 3
.end method

.method public <init>()V
.var 0 is this LTAPPLClass; from Label0 to Label1
Label0:
	aload_0
	invokespecial A1/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
