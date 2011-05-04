package appModel;

public abstract class Entity implements Persistible{
	
/* VARIABLES ***************************************************/

		private int id;
		
/* CONSTRUCTOR ***************************************************/

		public Entity() {		
		}

		public Entity(int id) {
			this.id = id;
		}
		
/* GET&SET***************************************************/

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

}