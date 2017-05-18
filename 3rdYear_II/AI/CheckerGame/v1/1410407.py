import pdb
import math
import imp
import time
# ======================== Class Player =======================================
class Player:
    def __init__(self, str_name):
        self.str = str_name

    def __str__(self):
        return self.str

    # Student MUST implement this function
    # The return value should be a move that is denoted by a list of tuples
    def nextMove(self, state):
        if self.str=='r':
            #result=self.listMove(state,self.str)
            #return result[0]
            return self.alphabeta(state,5,-10000,10000,'r')[1]
            #return self.best(state)
        else:
            #return self.best(state)
            #result=self.listMove(state,self.str)
            #return result[0]
            return self.alphabeta(state,5,-10000,10000,'b')[1]

    
    def army(self,state,r,c,army):
        if army=='b':
            if state[r][c]=='b':
                return Man('b')
            else:
                return King('b')
        else:
            if state[r][c]=='r':
                return Man('r')
            else:
                return King('r')
    def isManAllign(self,state,r,c):
        return self.str==state[r][c]
    def isManEnemy(self,state,r,c):
        if self.str=='b':
            return state[r][c]=='r'
        else:
            return state[r][c]=='b'
    
    def isKingAllign(self,state,r,c):
        if self.str=='b':
            return state[r][c]=='B'
        else:
            return state[r][c]=='R'
    def isKingEnemy(self,state,r,c):
        if self.str=='b':
            return state[r][c]=='R'
        else:
            return state[r][c]=='B'
    def isCorner(self,r,c):
        if c==0 or c==7 :
            return True
        else:
            return False
    def isHalfOpponent(self,r,c):
        if self.str=='b':
            return r<4
        else:
            return r>=4
    def isHalfTeam(self,r,c):
        if self.str=='b':
            return r>=4
        else:
            return r<=4
    def isKingRow(self,r,c):
        if self.str=='b':
            return r==0
        else:
            return r==7
    def isKingRowFor(self,r,c):
        if self.str=='b':
            return r==7
        else:
            return r==0
    # def score(self,board,listMoves):
    #     scores=[]
    #     for move in listMoves:
    #         newBoard=Board()
    #         newState=newBoard.boardCopy(board)
    #         newState=newBoard.doit(move,newState)
    #         if self.str=='r':
    #             score= self.alphabeta(newState,3,-10000,10000,'b')[0]
    #         else:
    #             score=self.alphabeta(newState,3,-10000,10000,'r')[0]
    #         scores.append(score)
    #     return scores
    #
    # def best(self,board):
    #     listMoves=self.listMove(board,self.str)
    #     scores=self.score(board,listMoves)
    #     maxScore=-10000
    #     temp=0
    #     for i in range(len(scores)):
    #         if scores[i]>maxScore:
    #             maxScore=scores[i]
    #             temp=i
    #     return listMoves[i]
    #
    def alphabeta(self,state,depth, alpha, beta,player):
        if depth==0:
            return self.eval(state),[]
        listMove=self.listMove(state,player)
        bestMove=listMove[0]
        score=0
        if (len(listMove)==1 and len(listMove[0])<1) or len(listMove)==0:
            return -1000,[]
        for i in range(0,len(listMove)):
            
        #         move= listMove[i]
        #         newBoard= newState.boardCopy(state)
        #         newBoard= newState.doit(move,newBoard)
        #         if player=='b':
        #             player='r'
        #         elif player=='r':
        #             player='b'
        #         temp=self.alphabeta(newBoard,depth-1,alpha,beta,bestAl,player)
        #         val= temp[0]
        #         if val>alpha:
        #             alpha=val
        #             bestMove=listMove[i]
        #         #if beta<= alpha:
        #             #break
        #     #return val,bestMove
        # else:
        #     for i in range(0,len(listMove)):
        #         newState=Board()
        #         move=listMove[i]
        #         newBoard=newState.boardCopy(state)
        #         newBoard= newState.doit(move,newBoard)
        #         if player=='b':
        #             player='r'
        #         elif player=='r':
        #             player='b'
        #         temp=self.alphabeta(newBoard,depth-1,alpha,beta,bestAl,player)
        #         val=temp[0]
        #         if beta>val:
        #             beta=val
        #             bestMove=listMove[i]
        #         #if beta<=alpha:
        #             #break
       # new alphabeta function
            move=listMove[i]
            newState=Board()
            newBoard=newState.boardCopy(state)
            newBoard= newState.doit(move,newBoard)

            if player==self.str:
                if player=='b':
                    player='r'
                elif player=='r':
                    player='b'
                score= self.alphabeta(newBoard,depth-1,alpha,beta,player)[0]
                if score> alpha:
                    alpha=score
                    bestMove=listMove[i]
            else:

                if player=='b':
                    player='r'
                elif player=='r':
                    player='b'
                score=self.alphabeta(newBoard,depth-1,alpha,beta,player)[0]
                if score<beta:
                    beta=score
                    bestMove=listMove[i]
            if (alpha>=beta):
                break
        if player==self.str:
            return alpha,bestMove
        else:
            return beta,bestMove
    #    return score,bestMove

    def plus(self,r):
        if self.str=='b':
            return 6-r
        else:
            return r-1

    def minus(self,r):
        if self.str=='b':
            return r-1
        else:
            return 6-r

    def eval(self,state):
        score=0
        allign=0
        enemy=0
        for r in range(0,8):
            for c in range(0,8):
                if self.isManEnemy(state,r,c):
                    score-=(100)
                    #score+=1
                    enemy+=1
                elif self.isManAllign(state,r,c):
                    #score+=3
                    allign+=1
                    score+=(100-self.plus(r)*3)
                    #score+=100
                elif self.isKingEnemy(state,r,c):
                    score-=300
                    #score-=3
                    enemy+=1
                elif self.isKingAllign(state,r,c):
                    score+=(300-abs(4-r)-abs(4-c))
                    #score+=300
                    #score-=1
                    allign+=1
        
        score+=((allign-enemy)*200)
        return score

    def listMove(self,state,army):
        listMove=[[]]
        isJump=False
        for r in range(0,8):
            for c in range(0,8):
                if self.validPick(state,r,c,army):
                    piece= self.army(state,r,c,army)
                    isJump=piece.canJump(state,r,c)
                    if isJump:
                        break
            if isJump:
                break
        for r in range(0,8):
            for c in range(0,8):
                if self.validPick(state,r,c,army):
                    piece= self.army(state,r,c,army)
                    if isJump:
                        listMove=listMove+piece.makeJump(state,r,c)
                    
                    else:
                        listMove=listMove+piece.makeMove(state,r,c)
                        
        if len(listMove)==1 and len(listMove[0])==0:
           return listMove
        else:
            del listMove[0]
            return listMove


    def validPick(self,state,posRow,posCol,army):
        if army == 'b':
            return state[posRow][posCol]=='b' or state[posRow][posCol]=='B'
        else:
            return state[posRow][posCol]=='r' or state[posRow][posCol]=='R'


class Man:

    def __init__(self,army):
        self.army= army

    def isValidMoveLeft(self,state,curRow,curCol):
        if self.army=='b':
            return self.isMove(state,curRow+1,curCol-1)
        else:
            return self.isMove(state,curRow-1,curCol+1)

    def isValidMoveRight(self,state,curRow,curCol):
        if self.army=='b':
            return self.isMove(state,curRow+1,curCol+1)
        else:
            return self.isMove(state,curRow-1,curCol-1)
    
    def maxLen(self,listMoves):
        maxLen=0
        for i in range(0,len(listMoves)):
            if maxLen<len(listMoves[i]):
                maxLen= len(listMoves[i])

        return maxLen
    def elimation(self,listMoves,length):
        listEle=[[]]
        count=0
        for i in range(0,len(listMoves)):
            if len(listMoves[i])!=length:
              listEle[count]+=listMoves[i]
              listEle.append([])
              count+=1
        
        for i in range(0,len(listEle)):
            if len(listEle[i])>1:
                listMoves.remove(listEle[i])

        return listMoves
        
    def makeMove(self,state,r,c):
        listMove=[[]]
        count=0
        if self.isValidMoveLeft(state,r,c):
            listMove[0].append((r,c))
            (rtem,ctem)=self.moveLeft(state,r,c)
            listMove[0].append((rtem,ctem))
            count=count+1
        if self.isValidMoveRight(state,r,c):
            if count==0:
                listMove[0].append((r,c))
                (rtem,ctem)=self.moveRight(state,r,c)
                listMove[0].append((rtem,ctem))
            else:
                listMove.append([])
                listMove[count].append((r,c))
                (rtem,ctem)=self.moveRight(state,r,c)
                listMove[count].append((rtem,ctem))

        if len(listMove[0])==0:
            return []
        return listMove
    def makeJump(self,state,r,c):
        listJump=[[]]
        count=0
        stack=[]
        turnRight=True
        rtem=r
        ctem=c
        while self.canJump(state,rtem,ctem) or len(stack)!=0:
            if self.isValidJumpLeft(state,rtem,ctem) and self.isValidJumpRight(state,rtem,ctem):
                
                listJump[count].append((rtem,ctem))
                if turnRight:
                    stack.append((rtem,ctem))
                    (rtem,ctem)=self.jumpRight(state,rtem,ctem)

                else:
                    (rtem,ctem)= self.jumpLeft(state,rtem,ctem)
                    turnRight=True
            elif self.isValidJumpLeft(state,rtem,ctem):
                listJump[count].append((rtem,ctem))
                (rtem,ctem)=self.jumpLeft(state,rtem,ctem)
            elif self.isValidJumpRight(state,rtem,ctem):
                listJump[count].append((rtem,ctem))
                (rtem,ctem)= self.jumpRight(state,rtem,ctem)
            elif not self.canJump(state,rtem,ctem) and len(stack)!=0:
                listJump.append([])
                count=count+1
                (rtem,ctem)= stack.pop()
                turnRight=False
                for i in range(0,len(listJump[count-1])):
                    listJump[count].append(listJump[count-1][i])
                
            if not self.canJump(state,rtem,ctem):
                listJump[count].append((rtem,ctem))

        if len(listJump[0])==0 and len(listJump)==1:
            return []
        
        maxLen=self.maxLen(listJump)
        listJump=self.elimation(listJump,maxLen)
        return listJump

    def isMove(self,state,nr,nc):
        if nr>7 or nc>7 or nr<0 or nc<0:
            return False
        else:
            if state[nr][nc]=='.':
                return True
            return False

    def isEnemy(self,state,r,c):
        if self.army=='b':
            return state[r][c]=='r' or state[r][c]=='R'
        else:
            return state[r][c]=='b' or state[r][c]=='B'

    def canJump(self,state,r,c):
        return self.isValidJumpLeft(state,r,c) or self.isValidJumpRight(state,r,c)

    def isValidJumpLeft(self,state,r,c):
        if self.army=='b':
            if self.isMove(state,r+2,c-2) and self.isEnemy(state,r+1,c-1):
                return True
            else:
                return False
        else:
            if self.isMove(state,r-2,c+2) and self.isEnemy(state,r-1,c+1):
                return True
            return False

    def isValidJumpRight(self,state,r,c):
         if self.army=='b':
             if self.isMove(state,r+2,c+2) and self.isEnemy(state,r+1,c+1):
                 return True
             else:
                 return False
         else:
            if self.isMove(state,r-2,c-2) and self.isEnemy(state,r-1,c-1):
                return True
            return False

    def moveLeft(self,state,r,c):
        if self.army=='b':
            return (r+1,c-1)
        else:
            return (r-1,c+1)

    def moveRight(self,state,r,c):
        if self.army=='b':
            return (r+1,c+1)
        else:
            return (r-1,c-1)

    def jumpRight(self,state,r,c):
        if self.army=='b':
            return (r+2,c+2)
        else:
            return (r-2,c-2)

    def jumpLeft(self,state,r,c):
        if self.army== 'b':
            return (r+2,c-2)
        else:
            return (r-2,c+2)
class King(Man):

    def isValidMoveBackLeft(self,state,r,c):
        if self.army=='b':
            if self.isMove(state,r-1,c-1):
                return True
        else:
            if self.isMove(state,r+1,c+1):
                return True
        return False

    def isValidMoveBackRight(self,state,r,c):
        if self.army=='b':
            if self.isMove(state,r-1,c+1):
                return True
        else:
            if self.isMove(state,r+1,c-1):
                return True
        return False

    def moveBackLeft(self,state,r,c):
        if self.army=='b':
            return (r-1,c-1)
        else:
            return (r+1,c+1)

    def moveBackRight(self,state,r,c):
        if self.army=='b':
            return (r-1,c+1)
        else:
            return (r+1,c-1)

    def isValidJumpLeft(self,state,r,c,captured):
        if self.army=='b':
            if self.isMove(state,r+2,c-2) and self.isEnemy(state,r+1,c-1) and captured.count((r+1,c-1))==0:
                return True
        else:
            if self.isMove(state,r-2,c+2) and self.isEnemy(state,r-1,c+1) and captured.count((r-1,c+1))==0:
                return True
        return False

    def isValidJumpRight(self,state,r,c,captured):
        if self.army=='b':
            if self.isMove(state,r+2,c+2) and self.isEnemy(state,r+1,c+1) and captured.count((r+1,c+1))==0:
                return True
        else:
            if self.isMove(state,r-2,c-2) and self.isEnemy(state,r-1,c-1) and captured.count((r-1,c-1))==0:
                return True

        return False

    def isValidJumpLeft(self,state,r,c,captured):
        if self.army=='b':
            if self.isMove(state,r+2,c-2) and self.isEnemy(state,r+1,c-1) and captured.count((r+1,c-1))==0:
                return True
        else:
            if self.isMove(state,r-2,c+2) and self.isEnemy(state,r-1,c+1) and captured.count((r-1,c+1))==0:
                return True
        return False

    def isValidJumpBackRight(self,state,r,c,captured):

        if self.army=='b':
            if self.isMove(state,r-2,c+2) and self.isEnemy(state,r-1,c+1) and captured.count((r-1,c+1))==0:
                return True
        else:
            if self.isMove(state,r+2,c-2) and self.isEnemy(state,r+1,c-1) and captured.count((r+1,c-1))==0:
                return True
        return False

    def isValidJumpBackLeft(self,state,r,c,captured):

        if self.army=='b':
            if self.isMove(state,r-2,c-2) and self.isEnemy(state,r-1,c-1) and captured.count((r-1,c-1))==0:
                return True
        else:
            if self.isMove(state,r+2,c+2) and self.isEnemy(state,r+1,c+1) and captured.count((r+1,c+1))==0:
                return True

        return False

    def jumpBackRight(self,state,r,c):
        if self.army=='b':
            return (r-2,c+2)
        else:
            return (r+2,c-2)

    def jumpBackLeft(self,state,r,c):
        if self.army=='b':
            return (r-2,c-2)
        else:
            return (r+2,c+2)

    def canJump(self,state,r,c):
        captured=[]
        return self.isValidJumpLeft(state,r,c,captured) or self.isValidJumpRight(state,r,c,captured) or self.isValidJumpBackLeft(state,r,c,captured) or self.isValidJumpBackRight(state,r,c,captured)

    def kingCanJump(self,state,r,c,captured):
        return self.isValidJumpLeft(state,r,c,captured) or self.isValidJumpRight(state,r,c,captured) or self.isValidJumpBackLeft(state,r,c,captured) or self.isValidJumpBackRight(state,r,c,captured)

    def directJump(self,state,r,c,captured):
        count=0
        if self.isValidJumpRight(state,r,c,captured):
            count=count+1
        if self.isValidJumpLeft(state,r,c,captured):
            count=count+1
        if self.isValidJumpBackRight(state,r,c,captured):
            count=count+1
        if self.isValidJumpBackLeft(state,r,c,captured):
            count=count+1
        return count

    def makeMove(self,state,r,c,):
        listMove=[[]]
        count=0

        if self.isValidMoveLeft(state,r,c):
            listMove[0].append((r,c))
            listMove[0].append(self.moveLeft(state,r,c))
            count=count+1
        if self.isValidMoveRight(state,r,c):
            if count==0:
                listMove[0].append((r,c))
                listMove[0].append(self.moveRight(state,r,c))
                count=count+1
            else:
                listMove.append([])
                listMove[count].append((r,c))
                listMove[count].append(self.moveRight(state,r,c))
                count=count+1
        if self.isValidMoveBackLeft(state,r,c):
            if count==0:
                listMove[0].append((r,c))
                listMove[0].append(self.moveBackLeft(state,r,c))
                count=count+1
            else:
                listMove.append([])
                listMove[count].append((r,c))
                listMove[count].append(self.moveBackLeft(state,r,c))
                count+=1
        if self.isValidMoveBackRight(state,r,c):
            if count==0:
                listMove[0].append((r,c))
                listMove[0].append(self.moveBackRight(state,r,c))
                count=count+1
            else:
                listMove.append([])
                listMove[count].append((r,c))
                listMove[count].append(self.moveBackRight(state,r,c))

        if len(listMove)==1 and len(listMove[0])==0:
            return []
        

        return listMove

    def captureLeft(self,r,c):
        if self.army=='b':
            return (r+1,c-1)
        else:
            return (r-1,c+1)
    def captureRight(self,r,c):
        if self.army=='b':
            return (r+1,c+1)
        else:
            return (r-1,c-1)

    def captureBackLeft(self,r,c):
        if self.army=='b':
            return (r-1,c-1)
        else:
            return (r+1,c+1)

    def captureBackRight(self,r,c):
        if self.army=='b':
            return (r-1,c+1)
        else:
            return (r+1,c-1)

    def direct(self,state,r,c,captured):

        left=self.isValidJumpLeft(state,r,c,captured)
        right= self.isValidJumpRight(state,r,c,captured)
        backLeft= self.isValidJumpBackLeft(state,r,c,captured)
        backRight= self.isValidJumpBackRight(state,r,c,captured)

        return Direction(r,c,left,right,backLeft,backRight)

    def makeJump(self,state1,r,c):
        listJump=[[]]
        count=0
        stack=[]
        captured=[]
        numbercap=[]
        useStack=False
        first=False
        board= Board()
        state=board.boardCopy(state1)
        state[r][c]='.'
        while self.kingCanJump(state,r,c,captured) or len(stack)!=0:

            directJump= self.directJump(state,r,c,captured)
            #pdb.set_trace()
            if directJump>1 and not useStack:
                direct=self.direct(state,r,c,captured)
                stack.append(direct)
                first=True
                #pdb.set_trace() 
            if (useStack or first):
                numbercap.append(len(captured))
                useStack=False
                first=False
                direct=stack.pop()
                out=True
                if self.isValidJumpLeft(state,r,c,captured) and direct.left==True:
                    out=False
                    direct.left=False
                    captured.append(self.captureLeft(r,c))
                    listJump[count].append((r,c))
                    (r,c)= self.jumpLeft(state,r,c)
                elif self.isValidJumpRight(state,r,c,captured) and direct.right==True:

                    out=False
                    direct.right=False
                    captured.append(self.captureRight(r,c))
                    listJump[count].append((r,c))
                    (r,c)= self.jumpRight(state,r,c)
                elif self.isValidJumpBackLeft(state,r,c,captured) and direct.backLeft==True:
                    direct.backLeft=False
                    out=False
                    captured.append(self.captureBackLeft(r,c))
                    listJump[count].append((r,c)) 
                    (r,c)= self.jumpBackLeft(state,r,c)
                elif self.isValidJumpBackRight(state,r,c,captured)and direct.backRight==True:
                    direct.backRight=False
                    out=False
                    captured.append(self.captureBackRight(r,c))
                    listJump[count].append((r,c)) 
                    (r,c)=self.jumpBackRight(state,r,c)

                stack.append(direct)
            else:


                if self.isValidJumpLeft(state,r,c,captured):
                    captured.append(self.captureLeft(r,c))
                    listJump[count].append((r,c))
                    (r,c)= self.jumpLeft(state,r,c)
                elif self.isValidJumpRight(state,r,c,captured):

                    captured.append(self.captureRight(r,c))
                    listJump[count].append((r,c))
                    (r,c)= self.jumpRight(state,r,c)
                elif self.isValidJumpBackLeft(state,r,c,captured):


                    captured.append(self.captureBackLeft(r,c))
                    listJump[count].append((r,c)) 
                    (r,c)= self.jumpBackLeft(state,r,c)
                elif self.isValidJumpBackRight(state,r,c,captured):

                    captured.append(self.captureBackRight(r,c))
                    listJump[count].append((r,c)) 
                    (r,c)=self.jumpBackRight(state,r,c)
            #pdb.set_trace()
            if not self.kingCanJump(state,r,c,captured) and len(stack)!=0:
                #pdb.set_trace()
                useStack=True
                out=False
                listJump[count].append((r,c))
                direct=stack.pop()


                while direct.left==False and direct.right==False and direct.backLeft==False and direct.backRight==False:

                    if len(stack)== 0:
                        out=True
                        break
                    numbercap.pop()
                    direct=stack.pop()
                #pdb.set_trace()
                if out: 
                    break

                (r,c)= (direct.row,direct.col)
                if direct.left==True or direct.right==True or direct.backLeft==True or direct.backRight==True:
                    stack.append(direct)
                    count=count+1
                    listJump.append([])

                lencap=numbercap.pop()
                while len(captured)!= lencap:
                    captured.pop()
                for i in range(0,lencap):
                    listJump[count].append(listJump[count-1][i])

                #pdb.set_trace()
            elif not self.kingCanJump(state,r,c,captured)and len(stack)==0:
                listJump[count].append((r,c))


        if len(listJump)==1 and len(listJump[0])==0:
            return []
        #maxLen= self.maxLen(listJump)
        #listJump= self.elimation(listJump,maxLen)
        
        maxLen=self.maxLen(listJump)
        listJump=self.elimation(listJump,maxLen)
        return listJump


class Direction:

    def __init__(self,r,c,left,right,backLeft,backRight):
        self.row=r
        self.col=c
        self.left=left
        self.right=right
        self.backLeft= backLeft
        self.backRight= backRight
class Board:
    def boardCopy(self,board):
    	new_board = [[]]*8
    	for i in range(8):
           	new_board[i] = [] + board[i]
    	return new_board
    def doit(self,move,state):
        new_state =self.boardCopy(state)
        #    new_state=state

            #Move one step
            #example: [(2,2),(3,3)] or [(2,2),(3,1)]
        if len(move) == 2 and abs(move[1][0] - move[0][0]) == 1:         
                new_state[move[0][0]][move[0][1]] = '.'
                if state[move[0][0]][move[0][1]] == 'b' and move[1][0] == 7:
                    new_state[move[1][0]][move[1][1]] = 'B'
                elif state[move[0][0]][move[0][1]] == 'r' and move[1][0] == 0:
                    new_state[move[1][0]][move[1][1]] = 'R'
                else:
                    new_state[move[1][0]][move[1][1]] = state[move[0][0]][move[0][1]]
            #Jump
            #example: [(1,1),(3,3),(5,5)] or [(1,1),(3,3),(5,1)]
        else:
                step = 0
                new_state[move[0][0]][move[0][1]] = '.'
                while step < len(move)-1:
                    new_state[int(math.floor((move[step][0]+ move[step+1][0])/2))][int(math.floor((move[step][1]+ move[step+1][1])/2))] = '.'                        
                    step = step+1
                if state[move[0][0]][move[0][1]] == 'b' and move[step][0] == 7:
                    new_state[move[step][0]][move[step][1]] = 'B'
                elif state[move[0][0]][move[0][1]] == 'r' and move[step][0] == 0:
                    new_state[move[step][0]][move[step][1]] = 'R'
                else:
                    new_state[move[step][0]][move[step][1]] = state[move[0][0]][move[0][1]]


        return new_state
