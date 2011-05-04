package model;
	
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	
	public class MyDate {

		private DateFormat df; 
		private java.util.Date d;
		
		/**
		 * Esta clase tiene como proposito simplificar la creacion de Dates
		 * a partir de String con el formato definido
		 */
		public MyDate(String fecha){
			try {
				this.df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				this.d = this.df.parse(fecha);
			} catch (ParseException e) {
				this.d = null;//mejorar
			}
		}

		public Date getFechaYHora(){
			return this.d;
		}
		
		@SuppressWarnings("deprecation")
		public String getFechaYHoraString(){ 
			return this.d.toLocaleString();
		}

	}