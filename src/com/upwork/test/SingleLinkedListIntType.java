package com.upwork.test;

public class SingleLinkedListIntType
{
	public Node startNode;
	public Node endNode ;
	public int singleLinkedListsize ;
	
	
	
    public SingleLinkedListIntType()
    {
        startNode = null;
        endNode = null;
        singleLinkedListsize = 0;
    }
	
	private class Node
	{
		private int data;
		private Node next;
		
		
		public Node()
	    {
			next = null;
	        data = 0;
	    }  
		
		public Node(int data,Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		/**
		 * set current node link to next node
		 * @param n
		 */
	    public void setLink(Node n)
	    {
	    	next = n;
	    }
	    
	    /**
	     * setting data to current node
	     * @param d
	     */
	    public void setData(int d)
	    {
	        data = d;
	    } 
	    
	    /**
	     * fetching link of next node
	     * @return
	     */
	    public Node getLink()
	    {
	        return next;
	    }  
	    
	    /**
	     * getting data from current node
	     * @return
	     */
	    public Integer getData()
	    {
	        return data;
	    }
	    
	}
	
    

    /**
     * appends an element into single linked list
     * @param val
     */
    public void appendElementIntoSingleLinkedList(int val)
    {
    	Node newNode = new Node(val,null);    
    	singleLinkedListsize++ ;    
    	
    	if(startNode == null) 
    	{
    		startNode = newNode;
    		endNode = startNode;
    	}
    	else 
    	{
    		endNode.setLink(newNode);
    		endNode = newNode;
    	}
    }
    
    
    /**
     * removes tail element from a single linked list
     * @param val
     */
    public void removeTailElementFromSingleLinkedList()
    {
    	if (singleLinkedListsize == 0) 
        {
            System.out.println("linked list is empty and unable to remove tail element ");
            return;
        }
        
    	else if (startNode.getLink() == null) 
        {
    		singleLinkedListsize--;
            startNode = null;
            return;
        }
    	else
    	{
    		Node node = startNode;
    		while(node.next.next != null) 
    		{
    	        node = node.next;
    	    }

    	    node.setLink(null);
    	    singleLinkedListsize--;
    	}
    }
    
    /**
     * appends an element into single linked list
     * @param targetValue
     */
    public void removeElementsGreaterThanTargetValueIntoSingleLinkedList(int targetValue)
    {
    	if (singleLinkedListsize == 0) 
        {
            System.out.println("linked list is empty and unable to remove elements greater than target value");
            return;
        }
        
    	else if (startNode.getLink() == null && startNode.getData()>targetValue) 
        {
    		singleLinkedListsize--;
            startNode = null;
            return;
        }
    	else
    	{
    		
    		
    		Node node = startNode;
    		Node previousNode = startNode;
    		
    		int counter = 0;
    		
    		while(node.next != null) 
    		{
    	        if(node.getData()>targetValue)
    	        {
    	        	
    	        	previousNode.setLink(node.next);
    	        	node=previousNode.next;
    	        	singleLinkedListsize--;
    	        	
    	        }
    	        else
    	        {
    	        	previousNode = node;
    	        	node = node.next;
    	        }
    	        
    	        counter++;
    	    }
    		
    		if(node.next == null)
    		{
    			 if(node.getData()>targetValue)
     	        {
     	        	previousNode.setLink(node.next);
     	        	node.setLink(null);
     	        	singleLinkedListsize--;
     	        }
     	        else
     	        {
     	        	previousNode = node;
     	        	node = node.next;
     	        }
    		}
    		
    		if(startNode!=null && startNode.getData()>targetValue)
    		{
    			startNode=null;
    			singleLinkedListsize--;
    		}
    	    
    	}
    }
    
    /**
     * display elements of a single linked list
     */
    public void display()
    {
         System.out.println(" displaying elements of a single linked list ");     
        if (startNode==null || singleLinkedListsize == 0) 
        {
            System.out.println("No data exist in linked list");
            return;
        }
        
        if (startNode.getLink() == null) 
        {
            System.out.println(startNode.getData() );
            return;
        }
        
        Node node = startNode;
        
        System.out.print(startNode.getData()+ "->");
        
        node = startNode.getLink();
       
        while (node.getLink() != null)
        {
            System.out.print(node.getData()+ "->");
            node = node.getLink();
        }
        
        System.out.print(node.getData()+ "\n");
    }
	
	
	public static void main(String[] args) 
	{
		
			SingleLinkedListIntType singleLinkedListIntType = new SingleLinkedListIntType();
			
			//... appending elements in a single linked list
			System.out.println(" Appending Elements 1 to 8 in a Single Linked List ");
			System.out.println();
			singleLinkedListIntType.appendElementIntoSingleLinkedList(1);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(2);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(3);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(4);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(5);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(6);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(7);
			singleLinkedListIntType.appendElementIntoSingleLinkedList(8);
			
			//... displaying elements in a single linked list
			singleLinkedListIntType.display();
			System.out.println();
			
			
			//... removing tail element in a single linked list
			System.out.println(" Removing tail element in a single linked list ");
			singleLinkedListIntType.removeTailElementFromSingleLinkedList();
			System.out.println();
			
			//... displaying elements in a single linked list
			singleLinkedListIntType.display();
			System.out.println();
			
			//... removing all elements in a single linked list that are greater than target value
			int targetValue = 3;
			System.out.println(" Removing all elements in a single linked list that are greater than target value "+targetValue);
			singleLinkedListIntType.removeElementsGreaterThanTargetValueIntoSingleLinkedList(targetValue);
			System.out.println();
			singleLinkedListIntType.display();
			
			
	}

}
