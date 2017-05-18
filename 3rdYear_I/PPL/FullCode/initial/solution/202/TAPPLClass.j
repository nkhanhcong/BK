.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
Label0:
	fconst_1
	iconst_1
	iconst_2
	imul
	iconst_3
	idiv
	fconst_1
	swap
	i2f
	swap
	fdiv
	fadd
	invokestatic io/writeFloat(F)V
Label1:
	return
.limit stack 3
.limit locals 1
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
