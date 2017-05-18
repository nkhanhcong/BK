.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field x I

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is b Z from Label0 to Label1
.var 2 is t F from Label0 to Label1
.var 3 is s Ljava/lang/String; from Label0 to Label1
.var 4 is ss Ljava/lang/String; from Label0 to Label1
Label0:
	ldc 3.5
	fstore_2
	ldc "abc"
	astore_3
	aload_3
	aload_3
	invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
	astore 4
	iconst_1
	istore_1
	iload_1
	invokestatic io/writeBoolLn(Z)V
	iconst_0
	istore_1
	fload_2
	invokestatic io/writeFloatLn(F)V
	aload_3
	invokestatic io/writeStrLn(Ljava/lang/String;)V
Label1:
	return
.limit stack 2
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
