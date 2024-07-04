class STack {
	int top;
	int size;
	char[] arr;
	public STack(int n)
	{
		top=-1;
		size=n;
		arr=new char[n];
	}
	public boolean IsEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public char peek()
	{
		if(top==-1)
		{
			return 'N';
		}
		else
		{
			return arr[top];
		}
	}
	public void push(char a)
	{
		if(top==-1)
		{
			top=0;
			arr[top]=a;
		}
		else if(top==size-1)
		{
			System.out.println("Stack is full");
		}
		else
		{
			top=top+1;
			arr[top]=a;
		}
	}
	public void pop()
	{
		if(top==-1)
		{
			System.out.println("Stack is Empty");
		}
		else
		{
			top=top-1;
		}
	}
}

class Solution {
    public boolean isValid(String s) {
        STack stack=new STack(s.length());
        for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				continue;
			}
			if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
			{
				stack.push(s.charAt(i));
			}
			if(s.charAt(i)=='}')
			{
				if(stack.peek()!='{')
				{
					return false;
				}
				else
				{
					stack.pop();
				}
			}
			if(s.charAt(i)==')')
			{
				if(stack.peek()!='(')
				{
					return false;
				}
				else
				{
					stack.pop();
				}
			}
			if(s.charAt(i)==']')
			{
				if(stack.peek()!='[')
				{
					return false;
				}
				else
				{
					stack.pop();
				}
			}
		}
		if(stack.IsEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
    }
}