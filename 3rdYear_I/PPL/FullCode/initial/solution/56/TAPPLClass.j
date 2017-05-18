.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static theAnswerForLifeUniverseAndEverything()I
Label0:
	bipush 42
	ireturn
Label1:
.limit stack 1
.limit locals 0
.end method

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
Label0:
	invokestatic TAPPLClass/theAnswerForLifeUniverseAndEverything()I
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 1
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
