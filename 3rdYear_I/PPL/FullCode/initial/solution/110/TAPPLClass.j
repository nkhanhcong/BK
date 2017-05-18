.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static add(I)I
.var 0 is n I from Label0 to Label1
Label0:
	iload_0
	iconst_5
	iadd
	ireturn
Label1:
.limit stack 2
.limit locals 1
.end method

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is temp I from Label0 to Label1
.var 2 is b I from Label0 to Label1
Label0:
	bipush 8
	istore_1
	iload_1
	invokestatic TAPPLClass/add(I)I
	istore_2
	iload_2
	invokestatic io/writeInt(I)V
Label1:
	return
.limit stack 1
.limit locals 3
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
