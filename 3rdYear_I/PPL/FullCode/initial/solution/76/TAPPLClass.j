.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is a I from Label0 to Label1
.var 2 is b F from Label0 to Label1
.var 3 is res F from Label0 to Label1
Label0:
	iconst_4
	istore_1
	iconst_5
	iconst_2
	swap
	i2f
	swap
	i2f
	fdiv
	fstore_2
	iload_1
	fload_2
	swap
	i2f
	swap
	fadd
	fstore_3
	fload_3
	invokestatic io/writeFloatLn(F)V
Label1:
	return
.limit stack 2
.limit locals 4
.end method

.method public <init>()V
.var 0 is this LTAPPLClass; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
