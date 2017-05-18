.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public XXX()Ljava/lang/String;
.var 0 is this LTAPPLClass; from Label0 to Label1
Label0:
	ldc "hi"
	ldc "hi"
	invokevirtual java/lang/String/concat(Ljava/lang/String;)Ljava/lang/String;
	areturn
Label1:
.limit stack 2
.limit locals 1
.end method

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is c LTAPPLClass; from Label0 to Label1
.var 2 is d Ljava/lang/String; from Label0 to Label1
Label0:
	new TAPPLClass
	dup
	invokespecial TAPPLClass/<init>()V
	astore_1
	aload_1
	invokevirtual TAPPLClass/XXX()Ljava/lang/String;
	astore_2
	aload_2
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
