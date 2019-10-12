package com.atguigu.map;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author 86177
 *
 *1.故障现象
 *java.util.ConcurrentModificationException
 *
 *2.导致原因
 *
 *3.解决方法
 *3.1 :  Collections.synchronizedMap(new HashMap<String, String>());
 *3.2 :  new ConcurrentHashMap<>();
 *4.优化建议
 */
public class MapConcurret {
	public static void main(String[] args) {
		Map<String,String> map = new ConcurrentHashMap<>();
		
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 6));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
	}
}
