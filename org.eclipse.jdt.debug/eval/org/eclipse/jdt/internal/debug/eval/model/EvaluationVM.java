package org.eclipse.jdt.internal.debug.eval.model;

/*
 * (c) Copyright IBM Corp. 2002.
 * All Rights Reserved.
 */
 
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.debug.core.IJavaDebugTarget;
import org.eclipse.jdt.debug.core.IJavaType;
import org.eclipse.jdt.debug.core.IJavaValue;

/**
 * Proxy to a Java debug target
 */
public class EvaluationVM extends EvaluationElement implements IVirtualMachine {

	/**
	 * Underlying Java debug target
	 */
	private IJavaDebugTarget fJavaDebugTarget;
	
	/**
	 * Constructs a proxy to the given Java debug target.
	 * 
	 * @param target Java debug target
	 * @return prxoxy to the given target
	 */
	protected EvaluationVM(IJavaDebugTarget target) {
		setJavaDebugTarget(target);
	}
	
	/**
	 * @see EvaluationElement#getUnderlyingModelObject()
	 */
	protected Object getUnderlyingModelObject() {
		return getJavaDebugTarget();
	}

	/**
	 * @see IVirtualMachine#newValue(boolean)
	 */
	public IValue newValue(boolean value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(byte)
	 */
	public IValue newValue(byte value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(char)
	 */
	public IValue newValue(char value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(double)
	 */
	public IValue newValue(double value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(float)
	 */
	public IValue newValue(float value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(int)
	 */
	public IValue newValue(int value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(long)
	 */
	public IValue newValue(long value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(short)
	 */
	public IValue newValue(short value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#newValue(String)
	 */
	public IObject newValue(String value) {
		IJavaValue v = getJavaDebugTarget().newValue(value);
		return (IObject)EvaluationValue.createValue(v);
	}

	/**
	 * @see IVirtualMachine#classesByName(String)
	 */
	public IType[] classesByName(String qualifiedName) throws CoreException {
		IJavaType[] types = getJavaDebugTarget().getJavaTypes(qualifiedName);
		if (types != null) {
			IType[] theTypes = new IType[types.length];
			for (int i = 0; i < types.length; i++) {
				theTypes[i] = EvaluationType.createType(types[i]);
			}
			return theTypes;
		}
		return new IType[0];
	}

	/**
	 * @see IVirtualMachine#nullValue()
	 */
	public IValue nullValue() {
		return EvaluationValue.createValue(getJavaDebugTarget().nullValue());
	}

	/**
	 * @see IVirtualMachine#voidValue()
	 */
	public IValue voidValue() {
		return EvaluationValue.createValue(getJavaDebugTarget().voidValue());
	}

	/**
	 * Returns the underlying Java debug target.
	 * 
	 * @return the underlying Java debug target
	 */
	protected IJavaDebugTarget getJavaDebugTarget() {
		return fJavaDebugTarget;
	}

	/**
	 * Sets the underlying Java debug target.
	 * 
	 * @param javaDebugTarget Java debug target
	 */
	private void setJavaDebugTarget(IJavaDebugTarget javaDebugTarget) {
		fJavaDebugTarget = javaDebugTarget;
	}

}

