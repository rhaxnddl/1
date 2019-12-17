// 2019.12.12 ÀÌÇö°æ
// HashCode
package h_api;

public class Key {
	public int number;
	
	public Key(int n) {
		this.number = n;
	}
	@Override
	public int hashCode() {
		return this.number;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Key) {
			Key k = (Key)obj;
			if(this.number == k.number) {
				b = true;
			}
		}		
		return b;
	}
}
