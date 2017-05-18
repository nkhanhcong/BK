.source Person.java
.class public Person
.super java.lang.Object
.field age I

.method public intro()V
.var 0 is this LPerson; from Label0 to Label1
Label0:
	ldc "I am "
	invokestatic io/writeStr(Ljava/lang/String;)V
	aload_0
	getfield Person.age I
	invokestatic io/writeInt(I)V
Label1:
	return
.limit stack 1
.limit locals 1
.end method

.method public <init>()V
.var 0 is this LPerson; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
