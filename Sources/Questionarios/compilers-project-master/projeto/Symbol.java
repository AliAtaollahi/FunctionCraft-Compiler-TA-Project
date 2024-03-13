

public abstract class Symbol
{
   public Symbol(String name, Type type) {
      assert name != null;
      assert type != null;

      this.name = name;
      this.type = type;
      this.value = null;
   }


   public String name(){
      return name;
   }

   public Type type(){
      return type;
   }

   public void setValue(Object value) {
	this.value = value;	
   }

   public Object getValue() {
	return this.value;
   }

   protected final String name;
   protected final Type type;
   protected Object value;
}


