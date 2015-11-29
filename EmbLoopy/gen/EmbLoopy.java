/**
 * GENERATED CODE - DO NOT CHANGE
 */

import astra.acre.*;
import astra.cartago.*;
import astra.core.*;
import astra.event.*;
import astra.messaging.*;
import astra.formula.*;
import astra.lang.*;
import astra.eis.*;
import astra.statement.*;
import astra.term.*;
import astra.type.*;
import astra.tr.*;
import astra.util.*;

public class EmbLoopy extends ASTRAClass {
	public EmbLoopy() {
		setParents(new Class[] {astra.lang.Agent.class});
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("init", new Term[] {})
				)
			),
			Predicate.TRUE,
			new Block(
				"EmbLoopy", new int[] {7,18,12,5},
				new Statement[] {
					new ModuleCall("console",
						"EmbLoopy", new int[] {8,8,8,42},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Started program")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("EmbLoopy","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"EmbLoopy", new int[] {9,8,12,5},
						new Goal(
							new Predicate("print", new Term[] {
								Primitive.newPrimitive(1),
								Primitive.newPrimitive(5)
							})
						)
					),
					new ModuleCall("console",
						"EmbLoopy", new int[] {10,8,10,40},
						new Predicate("println", new Term[] {
							Primitive.newPrimitive("Finished Loop")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("EmbLoopy","console")).println(
									(java.lang.String) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new ModuleCall("system",
						"EmbLoopy", new int[] {11,8,11,21},
						new Predicate("exit", new Term[] {}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.System) intention.getModule("EmbLoopy","system")).exit(
								);
							}
						}
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("print", new Term[] {
						new Variable(Type.INTEGER, "X"),
						new Variable(Type.INTEGER, "N")
					})
				)
			),
			new Comparison("<",
				new Variable(Type.INTEGER, "X"),
				new Variable(Type.INTEGER, "N")
			),
			new Block(
				"EmbLoopy", new int[] {14,39,17,5},
				new Statement[] {
					new ModuleCall("console",
						"EmbLoopy", new int[] {15,8,15,26},
						new Predicate("println", new Term[] {
							new Variable(Type.INTEGER, "X")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("EmbLoopy","console")).println(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					),
					new Subgoal(
						"EmbLoopy", new int[] {16,8,17,5},
						new Goal(
							new Predicate("print", new Term[] {
								Operator.newOperator('-',
									new Variable(Type.INTEGER, "X"),
									Primitive.newPrimitive(1)
								),
								Primitive.newPrimitive(5)
							})
						)
					)
				}
			)
		));
		addRule(new Rule(
			new GoalEvent('+',
				new Goal(
					new Predicate("print", new Term[] {
						new Variable(Type.INTEGER, "X"),
						new Variable(Type.INTEGER, "N")
					})
				)
			),
			new Comparison("==",
				new Variable(Type.INTEGER, "X"),
				new Variable(Type.INTEGER, "N")
			),
			new Block(
				"EmbLoopy", new int[] {19,40,21,5},
				new Statement[] {
					new ModuleCall("console",
						"EmbLoopy", new int[] {20,8,20,26},
						new Predicate("println", new Term[] {
							new Variable(Type.INTEGER, "X")
						}),
						new ModuleCallAdaptor() {
							public boolean invoke(Intention intention, Predicate predicate) {
								return ((astra.lang.Console) intention.getModule("EmbLoopy","console")).println(
									(java.lang.Integer) intention.evaluate(predicate.getTerm(0))
								);
							}
						}
					)
				}
			)
		));
	}

	public void initialize(astra.core.Agent agent) {
		agent.initialize(
			new Goal(
				new Predicate("init", new Term[] {})
			)
		);
	}

	public Fragment createFragment(astra.core.Agent agent) throws ASTRAClassNotFoundException {
		Fragment fragment = new Fragment(this);
		fragment.addModule("console",astra.lang.Console.class,agent);
		fragment.addModule("system",astra.lang.System.class,agent);
		return fragment;
	}

	public static void main(String[] args) {
		ListTerm argList = new ListTerm();
		for (String arg: args) {
			argList.add(Primitive.newPrimitive(arg));
		}

		String name = java.lang.System.getProperty("astra.name", "main");
		try {
			astra.core.Agent agent = new EmbLoopy().newInstance(name);
			agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
			Scheduler.schedule(agent);
		} catch (AgentCreationException e) {
			e.printStackTrace();
		} catch (ASTRAClassNotFoundException e) {
			e.printStackTrace();
		};
	}
}
