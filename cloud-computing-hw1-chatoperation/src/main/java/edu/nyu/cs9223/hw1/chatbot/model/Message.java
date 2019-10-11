/**
 * null
 */
package edu.nyu.cs9223.hw1.chatbot.model;

import java.io.Serializable;

/**
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/ljp1k3l5m2-1.0.0/Message" target="_top">AWS API
 * Documentation</a>
 */
public class Message implements Serializable, Cloneable {

    private String type;

    private UnstructuredMessage unstructured;

    /**
     * @return
     */

    public String getType() {
        return this.type;
    }

    /**
     * @param type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param type
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Message type(String type) {
        setType(type);
        return this;
    }

    /**
     * @return
     */

    public UnstructuredMessage getUnstructured() {
        return this.unstructured;
    }

    /**
     * @param unstructured
     */

    public void setUnstructured(UnstructuredMessage unstructured) {
        this.unstructured = unstructured;
    }

    /**
     * @param unstructured
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public Message unstructured(UnstructuredMessage unstructured) {
        setUnstructured(unstructured);
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
        if (getType() != null) {
            sb.append("Type: ").append(getType()).append(",");
        }
        if (getUnstructured() != null) {
            sb.append("Unstructured: ").append(getUnstructured());
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Message == false)
            return false;
        Message other = (Message) obj;
        if (other.getType() == null ^ this.getType() == null)
            return false;
        if (other.getType() != null && other.getType().equals(this.getType()) == false)
            return false;
        if (other.getUnstructured() == null ^ this.getUnstructured() == null)
            return false;
        if (other.getUnstructured() != null && other.getUnstructured().equals(this.getUnstructured()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getType() == null) ? 0 : getType().hashCode());
        hashCode = prime * hashCode + ((getUnstructured() == null) ? 0 : getUnstructured().hashCode());
        return hashCode;
    }

    @Override
    public Message clone() {
        try {
            return (Message) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}
