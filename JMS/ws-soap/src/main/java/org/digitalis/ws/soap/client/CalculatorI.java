
package org.digitalis.ws.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CalculatorI", targetNamespace = "http://server.soap.ws.digitalis.org/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculatorI {

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(partName = "return")
	@Action(input = "http://server.soap.ws.digitalis.org/CalculatorI/addRequest", output = "http://server.soap.ws.digitalis.org/CalculatorI/addResponse")
	public int add(@WebParam(name = "arg0", partName = "arg0") int arg0,
			@WebParam(name = "arg1", partName = "arg1") int arg1);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(partName = "return")
	@Action(input = "http://server.soap.ws.digitalis.org/CalculatorI/divideRequest", output = "http://server.soap.ws.digitalis.org/CalculatorI/divideResponse")
	public int divide(@WebParam(name = "arg0", partName = "arg0") int arg0,
			@WebParam(name = "arg1", partName = "arg1") int arg1);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(partName = "return")
	@Action(input = "http://server.soap.ws.digitalis.org/CalculatorI/subtractRequest", output = "http://server.soap.ws.digitalis.org/CalculatorI/subtractResponse")
	public int subtract(@WebParam(name = "arg0", partName = "arg0") int arg0,
			@WebParam(name = "arg1", partName = "arg1") int arg1);

	/**
	 * 
	 * @param arg1
	 * @param arg0
	 * @return returns int
	 */
	@WebMethod
	@WebResult(partName = "return")
	@Action(input = "http://server.soap.ws.digitalis.org/CalculatorI/multiplyRequest", output = "http://server.soap.ws.digitalis.org/CalculatorI/multiplyResponse")
	public int multiply(@WebParam(name = "arg0", partName = "arg0") int arg0,
			@WebParam(name = "arg1", partName = "arg1") int arg1);

}
