/**
 * null
 */
package edu.nyu.cs9223.hw1.chatbot.model;

import java.io.Serializable;

/**
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ljp1k3l5m2-1.0.0/BotRequest" target="_top">AWS API
 * Documentation</a>
 */
public class BotRequest implements Serializable, Cloneable {

    private java.util.List<Message> messages;

    /**
     * @return
     */

    public java.util.List<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages
     */

    public void setMessages(java.util.Collection<Message> messages) {
        if (messages == null) {
            this.messages = null;
            return;
        }

        this.messages = new java.util.ArrayList<Message>(messages);
    }

    /**
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setMessages(java.util.Collection)} or {@link #messages(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     *
     * @param messages
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public BotRequest messages(Message... messages) {
        if (this.messages == null) {
            setMessages(new java.util.ArrayList<Message>(messages.length));
        }
        for (Message ele : messages) {
            this.messages.add(ele);
        }
        return this;
    }

    /**
     * @param messages
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public BotRequest messages(java.util.Collection<Message> messages) {
        setMessages(messages);
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and debugging.
     *
     * @return A string representation of this object.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMessages() != null)
            sb.append("Messages: ").append(getMessages());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof BotRequest == false)
            return false;
        BotRequest other = (BotRequest) obj;
        if (other.getMessages() == null ^ this.getMessages() == null)
            return false;
        if (other.getMessages() != null && other.getMessages().equals(this.getMessages()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getMessages() == null) ? 0 : getMessages().hashCode());
        return hashCode;
    }

    @Override
    public BotRequest clone() {
        try {
            return (BotRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
