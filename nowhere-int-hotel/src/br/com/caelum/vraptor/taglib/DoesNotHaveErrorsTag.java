package br.com.caelum.vraptor.taglib;

import java.util.Collection;

public class DoesNotHaveErrorsTag extends ConditionalTagSupport {

	private static final long serialVersionUID = 1L;

	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	protected boolean condition() throws JspTagException {

		@SuppressWarnings("unchecked")
		Collection<Message> errors = (Collection<Message>) pageContext.getRequest().getAttribute("errors");

		if (errors != null) {
			for (Message message : errors) {
				if (message.getCategory().equals(this.getCategory())) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;
	}

}
