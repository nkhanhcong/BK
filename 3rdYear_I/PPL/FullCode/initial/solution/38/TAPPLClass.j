.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
Label0:
	bipush 9
	bipush 32
	invokestatic TAPPLClass/fun(II)I
	bipush 23
	if_icmpgt Label2
	iconst_1
	goto Label3
Label2:
	iconst_0
Label3:
	ifeq Label4
	ldc "yes"
	invokestatic io/writeStrLn(Ljava/lang/String;)V
	goto Label5
Label4:
	ldc "no"
	invokestatic io/writeStrLn(Ljava/lang/String;)V
Label5:
Label1:
	return
.limit stack 2
.limit locals 1
.end method

.method public static fun(II)I
.var 0 is x I from Label0 to Label1
.var 1 is y I from Label0 to Label1
.var 2 is k I from Label0 to Label1
.var 3 is m Z from Label0 to Label1
.var 4 is n Z from Label0 to Label1
Label0:
	iload_0
	invokestatic io/writeIntLn(I)V
	iload_1
	ireturn
Label1:
.limit stack 1
.limit locals 5
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
