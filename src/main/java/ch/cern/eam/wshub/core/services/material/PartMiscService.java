package ch.cern.eam.wshub.core.services.material;

import java.util.List;

import ch.cern.eam.wshub.core.annotations.Operation;
import ch.cern.eam.wshub.core.client.InforContext;
import ch.cern.eam.wshub.core.interceptors.LogDataReferenceType;
import ch.cern.eam.wshub.core.services.INFOR_OPERATION;
import ch.cern.eam.wshub.core.services.material.entities.IssueReturnPartTransaction;
import ch.cern.eam.wshub.core.services.material.entities.*;
import ch.cern.eam.wshub.core.tools.InforException;

public interface PartMiscService {

    @Operation(logOperation = INFOR_OPERATION.PARTSUPP_C)
    String addPartSupplier(InforContext context, PartSupplier partSupplierParam) throws InforException;

    List<String> createIssueReturnTransaction(InforContext context, List<IssueReturnPartTransaction> issueReturnPartTransactionList) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.ISSUE_RET, logDataReference1 = LogDataReferenceType.RESULT, logDataReference2 = LogDataReferenceType.INPUTFIELD, logDataReference2FieldName = "storeCode")
    String createIssueReturnTransaction(InforContext context, IssueReturnPartTransaction issueReturnPartTransaction) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.PARTASSOC_C)
    String createPartAssociation(InforContext context, PartAssociation partAssociation) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.PARTASSOC_D)
    String deletePartAssociation(InforContext context, PartAssociation partAssociation) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.PARTSUBS_C)
    String createPartSubstitute(InforContext context, PartSubstitute partSubstitute) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.STOREBIN_C)
    String addStoreBin(InforContext context, Bin binParam) throws InforException;

    @Operation(logOperation = INFOR_OPERATION.PARTMAN_R)
    public PartManufacturer[] getPartManufacturers(InforContext context, String partCode) throws InforException;
}
