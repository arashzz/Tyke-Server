package io.tyke.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import io.tyke.repositories.BaseRepository;
import io.tyke.repositories.IBaseRepository;

public class TykeUtil {
	public static Type getParentGenericType(Class<?> model){
		ParameterizedType genericSuperClass = (ParameterizedType)model.getGenericSuperclass();
		return genericSuperClass.getActualTypeArguments()[0];
	}
	
	public static BaseRepository<?> getRepositoryForType(Type modelType) throws Exception{
		Reflections reflections = new Reflections("io.tyke.repositories");
		Set<Class<? extends BaseRepository>> subTypes = reflections.getSubTypesOf(BaseRepository.class);
		for(Class<? extends BaseRepository> repo:subTypes){
			if (getParentGenericType(repo) == modelType){
				Object obj = instantiate(null, repo);
				BaseRepository<?> tempBaseRepo = (BaseRepository<?>)obj;
				return (BaseRepository<?>)obj;
			}
		}
		return null;
	}
	
	public static Object convert(Class<?> target, String s) {
	    if (target == Object.class || target == String.class || s == null) {
	        return s;
	    }
	    if (target == Character.class || target == char.class) {
	        return s.charAt(0);
	    }
	    if (target == Byte.class || target == byte.class) {
	        return Byte.parseByte(s);
	    }
	    if (target == Short.class || target == short.class) {
	        return Short.parseShort(s);
	    }
	    if (target == Integer.class || target == int.class) {
	        return Integer.parseInt(s);
	    }
	    if (target == Long.class || target == long.class) {
	        return Long.parseLong(s);
	    }
	    if (target == Float.class || target == float.class) {
	        return Float.parseFloat(s);
	    }
	    if (target == Double.class || target == double.class) {
	        return Double.parseDouble(s);
	    }
	    if (target == Boolean.class || target == boolean.class) {
	        return Boolean.parseBoolean(s);
	    }
	    throw new IllegalArgumentException("Don't know how to convert to " + target);
	}
	public static Object instantiate(List<String> args, Class<?> modelClass) throws Exception {
	    // Search for an "appropriate" constructor.
	    for (Constructor<?> ctor : modelClass.getConstructors()) {
	        Class<?>[] paramTypes = ctor.getParameterTypes();

	        // If the arity matches, let's use it.
	        if (args == null){
	        	return ctor.newInstance();
	        }
	        else if (args.size() == paramTypes.length) {

	            // Convert the String arguments into the parameters' types.
	            Object[] convertedArgs = new Object[args.size()];
	            for (int i = 0; i < convertedArgs.length; i++) {
	                convertedArgs[i] = convert(paramTypes[i], args.get(i));
	            }

	            // Instantiate the object with the converted arguments.
	            return ctor.newInstance(convertedArgs);
	        }
	    }

	    throw new IllegalArgumentException("Don't know how to instantiate " + modelClass.getName());
	}
}
