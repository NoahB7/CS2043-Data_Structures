
/********************************
Name: Noah Buchanan
Username: ua203
Problem Set: PS5
Due Date: July 7, 2020
********************************/


public class UALinkedList {

	UACourse head;
	UACourse tail;

	public UACourse find(int courseId) {

		
		UACourse i = head;
		
		if (head.getCourseId() == courseId) {
			
			i.setAccessCount(i.getAccessCount()+1);
			return head;
			
		} else {

			while (i.next != null && i.next.getCourseId() != courseId) {
				i = i.next;
			}
			i.next.setAccessCount(i.next.getAccessCount()+1);
			return i.next;
		}
	}

	public void insert(UACourse s) {

		if (head == null) {

			head = s;
			tail = s;
		} else {

			if (s.getCourseId() < head.getCourseId()) {

				UACourse i = head;

				while (i.next != null && s.getAccessCount() < i.next.getAccessCount()) {
					i = i.next;
				}

				if (i.next.getCourseId() == s.getCourseId()) {

					System.out.println("ERROR - INVALID ID");
				} else if (i.next == null) {

					s.prev = i;
					i.next = s;
					tail = s;
					
				} else {

					s.prev = i;
					s.next = i.next;
					i.next.prev = s;
					i.next = s;
				}

			} else if (s.getCourseId() == head.getCourseId()) {

				System.out.println("ERROR - INVALID ID");
			} else {
				s.next = head;
				head = s;
				head.next.prev = head;
			}
		}
	}

	public void remove(UACourse c) {

		if (head != null) {
			if (head.getCourseId() == c.getCourseId()) {

				head.next.prev = null;
				head.next = head;
			} else {

				UACourse i = head;

				while (i.next != null && i.next.getCourseId() != c.getCourseId()) {

					i = i.next;
				}
				
				if(i.next == null) {
					i.prev.next = null;
					tail = i.prev;
				} else {
					i.prev.next = i.next;
					i.next.prev = i.prev;
				}

			}
		} else {
			System.out.println("List already empty");
		}
	}

	public void remove(int i) {

		if (head != null) {

			UACourse j = head;

			while (j.next != null && j.getCourseId() != i) {

				
				j = j.next;
			}

			if(j.next == null) {
				j.prev.next = null;
				tail = j.prev;
			} else {
				j.prev.next = j.next;
				j.next.prev = j.prev;
			}

		} else {
			System.out.println("List already empty");
		}
	}

	public void printList() {

		UACourse i = head;

		while (i != null) {

			System.out.println("|" + i.getCourseId() + "|" + i.getCourseName() + ": " + i.getCourseDescription());
			i = i.next;
		}
	}

	public void printListReversed() {

		UACourse i = tail;
		

		while (i != null) {
			
			System.out.println("|" + i.getCourseId() + "|" + i.getCourseName() + ": " + i.getCourseDescription());
			i = i.prev;
		}
	}

}
