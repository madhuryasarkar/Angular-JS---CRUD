package com.Service;



import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

//import com.sun.media.jfxmedia.Media;

import Model.Student;


@Produces(MediaType.TEXT_PLAIN)
@Provider
public class DemoStudentMessageWriter implements MessageBodyWriter<Student> {

	@Override
	public long getSize(Student student, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		String output=student.getName()+":"+student.getId();
		return output.length();
	}

	@Override
	public boolean isWriteable(Class<?> inputClass, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return inputClass==Student.class;
	}

	@Override
	public void writeTo(Student student, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4,
			MultivaluedMap<String, Object> arg5, OutputStream out) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		
		byte byteArray[]=(student.getName()+":"+student.getId()+":"+student.getMarks()).getBytes();
		out.write(byteArray);
	}

}
