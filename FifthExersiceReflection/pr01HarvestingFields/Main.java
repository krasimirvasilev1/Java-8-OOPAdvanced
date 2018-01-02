package FifthExersiceReflection.pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String input = console.readLine();
			if (input.equalsIgnoreCase("harvest")){
				break;
			}

			Field[] fields = RichSoilLand.class.getDeclaredFields();
			switch(input){
				case "protected":
					Arrays.stream(fields).filter(x -> Modifier.isProtected(x.getModifiers())).forEach(x -> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
					break;
				case "public":
					Arrays.stream(fields).filter(x -> Modifier.isPublic(x.getModifiers())).forEach(x -> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
					break;
				case "private":
					Arrays.stream(fields).filter(x -> Modifier.isPrivate(x.getModifiers())).forEach(x -> System.out.println(Modifier.toString(x.getModifiers())+" "+x.getType().getSimpleName()+" "+x.getName()));
					break;
				case "all":
					for (Field field : fields) {
						System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName());
					}
					break;

			}
		}
	}
}
