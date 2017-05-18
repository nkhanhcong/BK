.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field c I
.field f F

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x I from Label0 to Label1
.var 2 is y I from Label0 to Label1
Label0:
	iconst_2
	istore_2
	iload_2
	iconst_3
	iadd
	istore_1
	iload_1
	iload_2
	iadd
	invokestatic io/writeIntLn(I)V
	ldc "hello"
	invokestatic io/writeStr(Ljava/lang/String;)V
Label1:
	return
.limit stack 2
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
