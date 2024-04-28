package com.design;


import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PacketReceiver {
    public static void main(String[] args){

        PacketReceiver rec = new PacketReceiver();
        rec.StartPacket();
        rec.StartPacket();
        System.out.println(rec.GetCollectedPackets());
        System.out.println(rec.GetNumOfFailedParts());

        rec = new PacketReceiver();
        rec.StartPacket();
        rec.ReceivePart(1, "Word".hashCode(), "Word");
        rec.ReceivePart(0, "Hello ".hashCode(), "Hello ");
        rec.ReceivePart(2, "!".hashCode(), "!");
        System.out.println(rec.GetCollectedPackets());
        System.out.println(rec.GetNumOfFailedParts());

        rec = new PacketReceiver();
        rec.StartPacket();
        rec.ReceivePart(1, "Word".hashCode(), "Word");
        rec.ReceivePart(0, "Hello ".hashCode(), "Hello ");
        rec.ReceivePart(2, "!".hashCode(), "!");
        rec.StartPacket();
        rec.ReceivePart(100, "Packet".hashCode(), "Packet");
        rec.ReceivePart(101, "Receiver".hashCode(), "Receiver");
        System.out.println(rec.GetCollectedPackets());
        System.out.println(rec.GetNumOfFailedParts());

        rec = new PacketReceiver();
        rec.StartPacket();
        rec.ReceivePart(1, 111, "Word");
        rec.ReceivePart(2, "!".hashCode(), "!");
        rec.ReceivePart(0, "Hello ".hashCode(), "Hello ");
        rec.StartPacket();
        rec.ReceivePart(100, "Packet".hashCode(), "Packet");
        rec.ReceivePart(101, 0, " ");
        rec.ReceivePart(102, "Receiver".hashCode(), "Receiver");
        System.out.println(rec.GetCollectedPackets());
        System.out.println(rec.GetNumOfFailedParts());
    }
    private Map<Integer, TreeMap<Integer,String>> map;
    private int index, start, numberOfFailedParts;
    private List<String> mergedPackets;


    public PacketReceiver(){
        map = new HashMap<>();
        index =-1;
        start = 0;
        numberOfFailedParts =0;
        mergedPackets = new ArrayList<>();
    }

    public void StartPacket(){
        index++;
        map.put(index, new TreeMap<>());
    }

    public boolean ReceivePart(int id, int controlSum, String data){
        if(index==-1){
            numberOfFailedParts++;
            return false;
        }
        if(data.hashCode() == controlSum){
            map.get(index).put(id, data);
            return true;
        } else{
            numberOfFailedParts++;
            return false;
        }
    }

    public List<String> GetCollectedPackets(){
        while(start<map.size()){
            TreeMap<Integer, String> innerMap = map.get(start);
            StringBuilder sb = new StringBuilder();
            for(String value : innerMap.values()){
                sb.append(value);
            }
            mergedPackets.add(sb.toString());
            start++;
        }
        return mergedPackets;
    }

    public int GetNumOfFailedParts(){
        return this.numberOfFailedParts;
    }
}
