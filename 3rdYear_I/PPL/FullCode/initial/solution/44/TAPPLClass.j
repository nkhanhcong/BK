.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field a Lass2;

.method public multi(I)I
.var 0 is this LTAPPLClass; from Label0 to Label1
.var 1 is n I from Label0 to Label1
Label0:
	iload_1
	bipush 30
	iadd
	ireturn
Label1:
.limit stack 2
.limit locals 2
.end method

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x I from Label0 to Label1
Label0:
	iconst_5
	iconst_3
	iconst_2
	imul
	isub
	istore_1
	ldc "chuoi cua ban in ra la "
	invokestatic io/writeStr(Ljava/lang/String;)V
	ldc "ok"
	invokestatic io/writeStr(Ljava/lang/String;)V
Label1:
	return
.limit stack 3
.limit locals 2
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
