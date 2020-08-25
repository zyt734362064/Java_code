package com.Test0825;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-25
 */
class Card{
    private String rank;//点数
    private String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        /*return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';*/
        return "[" +  this.suit + this.rank + "]";
    }
}
public class Poker {
    public static void main(String[] args) {
        //创建一副扑克牌
        List<Card> pokers = buyPoker();
        //System.out.println(pokers);
        //洗牌
        Collections.shuffle(pokers);
        //发牌（假设有三个玩家，每个人发五张牌），每个玩家就是一个 List，就可以把每个人的手牌放到这个 List 中
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        for (int i = 0;i < 5;i++){
            for (int j = 0;j <3;j++){
                List<Card> player = players.get(j);
                player.add(pokers.remove(0));
            }
        }
        //到这一步，玩家发牌结束，可以查看玩家的手牌了

        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" + players.get(i));
        }

    }
    private static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        String[] suits = {"♥","♠","♣","♦"};
        for (int i = 0;i < 4;i++){
            //这个循环来处理四种花色
            for (int j = 2;j <= 10;j++){
                poker.add(new Card("" + j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
    }
}
