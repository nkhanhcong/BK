.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field x I

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is t I from Label0 to Label1
.var 2 is s Ljava/lang/String; from Label0 to Label1
.var 3 is ss Ljava/lang/String; from Label0 to Label1
Label0:
	iconst_3
	istore_1
	ldc "abc"
	astore_2
	aload_2
	aload_2
	invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
	astore_3
	aload_3
	invokestatic io/writeStrLn(Ljava/lang/String;)V
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
