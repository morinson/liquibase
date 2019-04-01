package liquibase.parser.structureddata.mapping.core;

import liquibase.ExtensibleObject;
import liquibase.parser.ParsedNode;
import liquibase.parser.structureddata.mapping.AbstractParsedNodeMapping;
import liquibase.parser.structureddata.mapping.ParsedNodeMapping;

import java.lang.reflect.Type;

/**
 * Standard {@link ParsedNodeMapping} to use for an {@link ExtensibleObject} if nothing else has higher priority.
 * Adds no basic logic beyond what is in {@link AbstractParsedNodeMapping}
 */
public class DefaultExtensibleObjectParsedNodeMapping extends AbstractParsedNodeMapping {

    public DefaultExtensibleObjectParsedNodeMapping() {
    }

    @Override
    public int getPriority(ParsedNode parsedNode, Class objectType, Type containerType, String containerAttribute) {
        if (ExtensibleObject.class.isAssignableFrom(objectType)) {
            return PRIORITY_DEFAULT;
        }
        return PRIORITY_NOT_APPLICABLE;
    }

}