package persistencia;


public abstract class Entity implements Persistible{
	
/* VARIABLES ***************************************************/

		private int id;
		private int version;
		
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

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}

}
