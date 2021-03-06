/**
 * This file is part of the Joana IFC project. It is developed at the
 * Programming Paradigms Group of the Karlsruhe Institute of Technology.
 *
 * For further details on licensing please read the information at
 * http://joana.ipd.kit.edu or contact the authors.
 */
package edu.kit.joana.deprecated.jsdg.sdg.parammodel.objgraph.params;


import java.util.Set;

import com.ibm.wala.ipa.callgraph.propagation.InstanceKey;
import com.ibm.wala.ipa.callgraph.propagation.PointerKey;
import com.ibm.wala.types.TypeReference;
import com.ibm.wala.util.intset.OrdinalSet;

import edu.kit.joana.deprecated.jsdg.sdg.nodes.ParameterField;

/**
 * Actual-out nodes passed through the heap.
 *
 * @author Juergen Graf <graf@kit.edu>
 *
 */
public class ActOutHeapNode extends ActOutNode {

	public final OrdinalSet<InstanceKey> basePts;
	public final ParameterField baseField;

	ActOutHeapNode(OrdinalSet<InstanceKey> basePts, ParameterField baseField, int id,
			boolean isPrimitive, TypeReference type, Set<PointerKey> pKey, OrdinalSet<InstanceKey> pts, int callId) {
		super(id, type, isPrimitive, pKey, pts, callId);
		this.basePts = basePts;
		this.baseField = baseField;
	}

	ActOutHeapNode(ParameterField baseField, int id, boolean isPrimitive, TypeReference type,
			Set<PointerKey> pKey, OrdinalSet<InstanceKey> pts, int callId) {
		super(id, type, isPrimitive, pKey, pts, callId);
		this.basePts = null;
		this.baseField = baseField;
	}

	public final boolean isOnHeap() {
		return true;
	}

	public final OrdinalSet<InstanceKey> getBasePointsTo() {
		return basePts;
	}

	public final ParameterField getBaseField() {
		return baseField;
	}

}
