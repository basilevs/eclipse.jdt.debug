package org.eclipse.jdt.debug.core;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
 
import org.eclipse.debug.core.DebugException;
 
/**
 * The class of an object on a Java debug target.
 * <p>
 * Clients are not intended to implement this interface.
 * </p>
 * @see IJavaValue
 * @since 2.0
 */
public interface IJavaClassType  extends IJavaType {
	
	/**
	 * Returns a new instance of this class by invoking the
	 * constructor with the given signature and arguments in
	 * the specified thread. The given thread is resumed to perform this
	 * method invocation and suspends in its original location when
	 * this method invocation is complete. This method does not return
	 * until the method invocation is complete. Resuming the specified thread
	 * can result in breakpoints being hit, infinite loops, and deadlock.
	 * 
	 * @param signature the JNI style signature of the method to be invoked
	 * @param args the arguments of the constructor, which can be
	 * 	<code>null</code> or emtpy if there are none
	 * @param thread the thread in which to invoke the constructor
	 * @return the result of invoking the constructor
	 * @exception DebugException if this method fails. Reasons include:<ul>
	 * <li>Failure communicating with the VM.  The DebugException's
	 * status code contains the underlying exception responsible for
	 * the failure.</li>
	 * <li>This type does not implement the specified constructor</li>
	 * <li>An exception occurs while invoking the specified constructor</li>
	 * </ul>
	 */
	public IJavaObject newInstance(String signature, IJavaValue[] args, IJavaThread thread) throws DebugException;	
	
	/**
	 * Returns the result of sending the specified message to this class
	 * with the given arguments in the specified thread (invokes a static
	 * method on this type). The given thread is resumed to perform this
	 * method invocation and suspends in its original location when this
	 * method invocation is complete. This method does not return until the
	 * method invocation is complete. Resuming the specified thread can
	 * result in breakpoints being hit, infinite loops, and deadlock.
	 * 
	 * @param selector the selector of the method to be invoked
	 * @param signature the JNI style signature of the method to be invoked
	 * @param args the arguments of the method, which can be
	 * 	<code>null</code> or emtpy if there are none
	 * @param thread the thread in which to invoke the method
	 * @return the result of invoking the method
	 * @exception DebugException if this method fails. Reasons include:<ul>
	 * <li>Failure communicating with the VM.  The DebugException's
	 * status code contains the underlying exception responsible for
	 * the failure.</li>
	 * <li>This object does not implement the specified method</li>
	 * <li>An exception occurs while invoking the specified method</li>
	 * </ul>
	 */
	public IJavaValue sendMessage(String selector, String signature, IJavaValue[] args, IJavaThread thread) throws DebugException;		
	
	/**
	 * Returns a variable representing the static field in this class
	 * with the given name, or <code>null</code> if there is no
	 * field with the given name, or the name is ambiguous.
	 * 
	 * @param name field name
	 * @return the variable representing a static field, or <code>null</code>
	 * @exception DebugException if this method fails.  Reasons include:
	 * <ul><li>Failure communicating with the VM.  The DebugException's
	 * status code contains the underlying exception responsible for
	 * the failure.</li>
	 * </ul>
	 */
	public IJavaVariable getField(String name) throws DebugException;	
	
	/**
	 * Returns the superclass of this class type, or <code>null</code>
	 * if no such class exists.
	 * 
	 * @return the superclass of this class type, or <code>null</code>
	 * @exception DebugException if this method fails.  Reasons include:
	 * <ul><li>Failure communicating with the VM.  The DebugException's
	 * status code contains the underlying exception responsible for
	 * the failure.</li>
	 * </ul>
	 */
	public IJavaClassType getSuperclass() throws DebugException;
	
	/**
	 * Returns the class object associated with this class type.
	 * 
	 * @return the class object associated with this class type
	 * @exception DebugException if this method fails.  Reasons include:
	 * <ul><li>Failure communicating with the VM.  The DebugException's
	 * status code contains the underlying exception responsible for
	 * the failure.</li>
	 * </ul>
	 */
	public IJavaClassObject getClassObject() throws DebugException;
}

