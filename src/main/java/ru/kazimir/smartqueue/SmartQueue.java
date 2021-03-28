package ru.kazimir.smartqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс хранит список добавляемых в него элементов и позволяет в любой момент вернуть масимальы элемент списка
 * @author kazimir
 *
 */
public class SmartQueue {
	
	private List<Integer> values = new LinkedList<Integer>();
	private List<Integer> sortedMaximums = new LinkedList<Integer>();

	private void addToSorted(Integer val) {
		int index = 0;
		if (sortedMaximums.isEmpty()) {
			sortedMaximums.add(val);
		} else {
			for (Integer sortedVal : sortedMaximums) {
				if (sortedVal >= val) {
					sortedMaximums.add(index, val);
					break;
				} else if (sortedMaximums.size() == index+1) {
					sortedMaximums.add(val);
					break;
				}
				index++;
			}
		}
	}
	
	private void removeFromSorted (Integer val) {
		int index = 0;
		if (!sortedMaximums.isEmpty()) {
			for (Integer sortedVal : sortedMaximums) {
				if (sortedVal == val) {
					sortedMaximums.remove(index);
					break;
				}
				index++;
			}
		}
	}
	
	/**
	 * Возврат текущего максимума
	 * @return
	 */
	public Integer getMaximum() {
		Integer val = 0;
		if (sortedMaximums.size() != 0) {
			val = sortedMaximums.get(sortedMaximums.size()-1);
		}
		return val;
	}
	
	
	/**
	 * Добавление элемента в список
	 * @param val
	 */
	public void add(Integer val) {
		values.add(val);
		addToSorted(val);
	}
	
	/**
	 * Удаление элемента из списка
	 */
	public void remove() {
		removeFromSorted(values.get(0));
		values.remove(0);
	}
	
	public static void main(String[] args) {
		SmartQueue sq = new SmartQueue();
		sq.add(5);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.add(1);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.add(2);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.add(5);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.add(9);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.remove();		
		System.out.println("Maximum = " + sq.getMaximum());
		sq.add(2);
		System.out.println("Maximum = " + sq.getMaximum());
		sq.remove();		
		System.out.println("Maximum = " + sq.getMaximum());
		sq.remove();		
		System.out.println("Maximum = " + sq.getMaximum());
		sq.remove();		
		System.out.println("Maximum = " + sq.getMaximum());
		sq.remove();		
		System.out.println("Maximum = " + sq.getMaximum());
	}

}
