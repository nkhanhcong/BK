.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is a F from Label0 to Label1
.var 2 is b F from Label0 to Label1
Label0:
	iconst_1
	i2f
	fstore_1
	ldc 2.5
	fstore_2
	fload_1
	fload_2
	fcmpl
	ifle Label2
	iconst_1
	goto Label3
Label2:
	iconst_0
Label3:
	ifeq Label4
	ldc "a>b"
	invokestatic io/writeStrLn(Ljava/lang/String;)V
	goto Label5
Label4:
	ldc "a<=b"
	invokestatic io/writeStrLn(Ljava/lang/String;)V
Label5:
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