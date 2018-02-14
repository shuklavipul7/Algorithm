import java.util.LinkedList;
import java.util.List;

public class EncryptDecrypt {
	
	class LinkedListNode{
		char data;
		LinkedListNode next;
		public LinkedListNode(char data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {

		String key = getKey("Atvt hrqgse, Cnikg", "Your friend, Alice");
		String decrypt = decrypt("Bjj",key);
		System.out.println(decrypt);
	}

	public static String decrypt(String encrypted, String key) {
		String de = "";
		char[] ca = encrypted.toCharArray();
		char[] k = key.toCharArray();
		int kI = 0;
		for (int i = 0; i < ca.length; i++) {
			if (kI == k.length)
				kI = 0;
			int cal = -1;
			if (ca[i] >= 65 && ca[i] <= 90)
				cal = 65;
			if (ca[i] >= 97 && ca[i] <= 122)
				cal = 97;

			if (cal > -1) {
				if (((int)ca[i]) - cal - Integer.parseInt(String.valueOf(k[kI])) >= 0)
					de += ((char)(Integer.valueOf((int)ca[i])-(Integer.parseInt(String.valueOf(k[kI])))));
				else
					de += ((char)(cal + 26 - Math.abs(((int)ca[i]) - cal - Integer.parseInt(String.valueOf(k[kI])))));
				kI++;
			}else{
				de += ca[i];
			}
		}
		return de;
	}

	public static String getKey(String e, String o) {
		e = e.replaceAll("\\s+","");
		e = e.replaceAll("[^a-zA-Z0-9]", "");
		e = e.toLowerCase();
		o = o.replaceAll("\\s+","");
		o = o.replaceAll("[^a-zA-Z0-9]", "");
		o = o.toLowerCase();
		String keyString="";
		LinkedListNode head = generateKeyLinkedList();
		char[]original=o.toCharArray();
		char[]encrypted=e.toCharArray();
		for(int i=0;i<original.length;i++){
			int counter=0;
			while(head.data!=original[i]){
				head=head.next;
			}
			while(head.data!=encrypted[i]){
				counter++;
				head=head.next;
			}
			keyString=keyString+counter;
		}
		int startingIndex = 7 - keyString.length()%7;
		return keyString.substring(startingIndex, startingIndex+7);
	}
	
	public static LinkedListNode generateKeyLinkedList(){
		EncryptDecrypt outer = new EncryptDecrypt();
		LinkedListNode a= outer.new LinkedListNode('a');
		LinkedListNode b= outer.new LinkedListNode('b');
		LinkedListNode c= outer.new LinkedListNode('c');
		LinkedListNode d= outer.new LinkedListNode('d');
		LinkedListNode e= outer.new LinkedListNode('e');
		LinkedListNode f= outer.new LinkedListNode('f');
		LinkedListNode g= outer.new LinkedListNode('g');
		LinkedListNode h= outer.new LinkedListNode('h');
		LinkedListNode i= outer.new LinkedListNode('i');
		LinkedListNode j= outer.new LinkedListNode('j');
		LinkedListNode k= outer.new LinkedListNode('k');
		LinkedListNode l= outer.new LinkedListNode('l');
		LinkedListNode m= outer.new LinkedListNode('m');
		LinkedListNode n= outer.new LinkedListNode('n');
		LinkedListNode o= outer.new LinkedListNode('o');
		LinkedListNode p= outer.new LinkedListNode('p');
		LinkedListNode q= outer.new LinkedListNode('q');
		LinkedListNode r= outer.new LinkedListNode('r');
		LinkedListNode s= outer.new LinkedListNode('s');
		LinkedListNode t= outer.new LinkedListNode('t');
		LinkedListNode u= outer.new LinkedListNode('u');
		LinkedListNode v= outer.new LinkedListNode('v');
		LinkedListNode w= outer.new LinkedListNode('w');
		LinkedListNode x= outer.new LinkedListNode('x');
		LinkedListNode y= outer.new LinkedListNode('y');
		LinkedListNode z= outer.new LinkedListNode('z');
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		f.next=g;
		g.next=h;
		h.next=i;
		i.next=j;
		j.next=k;
		k.next=l;
		l.next=m;
		m.next=n;
		n.next=o;
		o.next=p;
		p.next=q;
		q.next=r;
		r.next=s;
		s.next=t;
		t.next=u;
		u.next=v;
		v.next=w;
		w.next=x;
		x.next=y;
		y.next=z;
		z.next=a;
		return a;
	}
	

}


