package br.com.caelum.vraptor.taglib;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Dennys Fredericci
 * 
 */
public class ShowErrorsTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String category;

	private String html_tag;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int doEndTag() throws JspException {

		@SuppressWarnings("unchecked")
		Collection<Message> errors = (Collection<Message>) pageContext
				.getRequest().getAttribute("errors");

		if (errors != null) {
			for (Message message : errors) {
				if (message.getCategory().equals(this.getCategory())) {
					print(message);
				}
			}
		}

		return EVAL_PAGE;
	}

	private void print(Message message) throws JspException {
		try {
			if (this.getHtml_tag() != null) {
				pageContext.getOut().print(
						"<" + getHtml_tag() + ">" + message.getMessage() + "</"
								+ getHtml_tag() + ">" + "<br />");
			} else {
				pageContext.getOut().print(message.getMessage() + "<br />");
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
	}

	public String getHtml_tag() {
		return html_tag;
	}

	public void setHtml_tag(String html_tag) {
		this.html_tag = html_tag;
	}

}
