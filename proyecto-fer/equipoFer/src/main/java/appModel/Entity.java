package appModel;

public abstract class Entity  {
		private String id;
		
		public Entity() {
		
		}

		public Entity(String id) {
			this();
		}
		
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}

}
