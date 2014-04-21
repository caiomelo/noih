package br.com.caelum.vraptor.taglib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class HasErrorsTag extends ConditionalTagSupport {

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
		
		
		StringTokenizer st = new StringTokenizer(getCategory(),"||");
		List<String> categories = new ArrayList<String>();
		if (st.countTokens() > 0){
			while (st.hasMoreTokens()){
				categories.add(st.nextToken());
			}
		} else
			categories.add(getCategory());
		if (errors != null) {
			for (Message message : errors) {
//				if (message.getCategory().equals(this.getCategory())) 
				for (String string : categories) {
					if (string.equals(message.getCategory())) 	return true;
				}
			}
		}

		return false;
	}

}
